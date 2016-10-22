# EasyMaps Engine

High-level overview of how the engine will transform raw logs into labels for a known network.

## 1. Selecting Options

### Actions:

- User chooses the `LogReader` implementation to use, determining how to parse log files.
- User enters file path to logs.
- User chooses the `OptionProvider` implementation to use, providing thresholds and other options.

### End results:

- All necessary information and inputs to carry out the following steps.

## 2. Parsing Log Files and Sanitising Data

### Actions:

- For each log file:
  - Validate format of each log entry (throw an exception or warning for invalid lines, depending on preference in `OptionProvider`).
  - Count unique users that observed each trait.
  - Map traits to integers for less memory-intensive handling later.
- Remove traits from the `<Trait, integer>` map if they did not meet the threshold.
- For each log file:
  - Re-write entries into a single `LogFile` object, each containing a user ID and timestamp-ordered list of `LogEntry<int timestamp, int[] traits>` objects, skipping traits observed by too few users (as per the threshold from the `OptionsProvider`).

### End results:

- All inputs from the file system read into memory.
- Bi-directional `<Trait, int>` map.
- List of `LogFile` objects.

### Possible future changes:

- Write the `LogFile` objects and `<Trait, integer>` map back to disk, if they become too large to hold in memory.

## 3. Building the Observed Network

### Actions:

- Create disjoint set structure to build clusters, with one node per non-discarded trait.
- For every pair of traits in each `LogEntry` in each `LogFile`:
  - Count the number of users that have observed those two traits together.
  - If the count meets the threshold (as per the `OptionsProvider`), connect those traits in the disjoint set.
- Construct bi-directional `<trait ID, cluster ID>` map.
- Create a zero-edge graph with one node per final cluster - this will be the observed network.
- Construct a list of `ParsedLogFile` objects:
  - For each `LogEntry` in each `LogFile`, re-write the entry as a `ParsedLogEntry`, containing the timestamp and cluster ID *iff* the amount of traits corresponding to the same cluster meet the threshold set in the `OptionsProvider`.
- For each pair of contiguous `ParsedLogEntry` objects in each `ParsedLogFile`, connect the corresponding nodes in the observed network graph *iff* they meet the time constraints set by the `OptionsProvider`.

### End results:

- Bi-directional `<trait ID, cluster ID>` map.
- Graph with one node per cluster, representing the observed network.
  
## 4. Matching to the Ideal Network

Yeah. This bit should be fun. :weary: