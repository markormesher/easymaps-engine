# EasyMaps Engine

## Commands

To run main algorithm:

    gradle clean fatjar
    ./engine.sh <dataset-folder-name>
    
    # eg: ./engine.sh sample-64

To run walk generator:

    gradle clean fatjar
    ./walker.sh <dataset-folder-name>
    
    # eg: ./walker.sh sample-64

To run tests and generate coverage report:

    gradle test
    
    # test report: build/reports/tests/test/index.html
    # coverage report: build/reports/jacoco/index.html

## Sample Datasets

| Network | Nodes | Edges |
| --- | --- | --- |
| `sample-16` | 16 | 36 |
| `sample-32` | 32 | 78 |
| `sample-64` | 64 | 161 |
| `sample-128` | 128 | 310 |
| `sample-256` | 256 | 608 |
| - |  |  |
| `sample-bucharest` | 70 | 148 |
| `sample-london` | 269 | 612 |