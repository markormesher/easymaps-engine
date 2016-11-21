# EasyMaps Engine

## Commands

To run main algorithm:

    gradle clean fatjar
    java -jar build/libs/easymaps-engine-<version>.jar [options file]

To run walk generator:

    gradle clean fatjar
    java -jar build/libs/easymaps-engine-<version>.jar --walker [walker options file]

To run tests and generate coverage report:

    gradle test
    
    # test report: build/reports/tests/test/index.html
    # coverage report: build/reports/jacoco/index.html
