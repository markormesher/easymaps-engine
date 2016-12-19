# EasyMaps Engine

## Commands

To run main algorithm:

    gradle clean fatjar
    ./engine.sh <dataset-folder-name> [--no-graphs | --graphs] [--force]
    
    # eg: ./engine.sh sample-64

To run full dataset generator:

    gradle clean fatjar
    ./dataset-generator.sh
    
    # eg: ./dataset-generator.sh [--no-graphs | --graphs] [--force]

To run log generator:

    gradle clean fatjar
    ./log-generator.sh <dataset-folder-name> [--no-graphs | --graphs] [--force]
    
    # eg: ./log-generator.sh sample-64

To run tests and generate coverage report:

    gradle test
    
    # test report: build/reports/tests/test/index.html
    # coverage report: build/reports/jacoco/index.html

## Sample Datasets

See `datasets/summary.html` and `datasets-real/summary.html`.
