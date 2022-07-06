**E2E Acceptance test project. PoC of Selenuim Grid & TestNG.**
 

**How to run tests**

By default all tests run against google start page. This can be changes in compose script.

The Maven goal install is used to run whole test set.
Run `mvn clean install`.

Test suites that will be executed during this are listed in pom in surefire plugin configuration:

`<suiteXmlFiles>
<suiteXmlFile>./src/test/resources/config/ConfigChrome.xml</suiteXmlFile>
</suiteXmlFiles>`


 Execution parameters in config files:

 - `browser` - name of the browser to run tests on. Currently available 'firefox' and 'chrome'
 - `destination` - where execution is done, locally or on the grid.
 - `parallel` - method of parallelism (on test basis, class, method, etc.).
  
Test suites are created manually and can be checked in `//resources` directory.
For every test class to be executed in parallel dedicated entry in config file is created manually.
Currently available following configurations:
 
  - `Local` - Tests executed locally.
  - `ConfigChrome` - Tests executed on Grid in Chrome.
  - `ConfigFirefox` - Tests executed on Grid in Firefox.
  - `Combined` - Tests executed on Grid both in CH and FF at the same time.
  - `ParentConfig` - Configuration allows execution of multiple child configurations sequentially.
  

**How to start Grid**

Directory /scripts/docker (for *nix systems and Mac), as well as /scripts/docker-win (for windows 10) 
contain shell scripts needed to start 
Selenium Grid and Selenium nodes on local workstation.
Current compose script adapted to test against application running on localhost.

Docker compose: run script _compose.sh_
This will spawn Selenium Hub, two nodes of Firefox and two nodes of Chrome and bind all together. 

To stop and remove all containers used for this infrastructure run _stopInfra.sh_ .


