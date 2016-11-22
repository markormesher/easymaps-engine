# EasyMaps Engine

## Commands

To run main algorithm:

    gradle clean fatjar
    ./engine.sh <dataset-folder-name>

To run walk generator:

    gradle clean fatjar
    ./walker.sh <dataset-folder-name>

To run tests and generate coverage report:

    gradle test
    
    # test report: build/reports/tests/test/index.html
    # coverage report: build/reports/jacoco/index.html
