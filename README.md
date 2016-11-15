# EasyMaps Engine

## Commands

To run main algorithm:

    gradle clean fatjar
    java -jar build/libs/easymaps-engine-<version>.jar [options file]

To run walk generator:

    gradle clean fatjar
    java -jar build/libs/easymaps-engine-<version>.jar -walker [walker options file]

To run tests and generate coverage report:

    gradle cobertura

Test report will be located in build/reports/tests/test/index.html
Coverage report will be located in build/reports/cobertura/index.html
