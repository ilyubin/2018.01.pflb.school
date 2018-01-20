# Automation Web + Api

Automation project for ok.ru

  - Project: https://ok.ru/


## Setup Env ##

### Open Powershell ###

Open Powershell as administrator.

### Set execution policy ###

```powershell
> Set-ExecutionPolicy Unrestricted
```

```powershell
> Get-ExecutionPolicy
Unrestricted
```

### Install choco ###

https://chocolatey.org/install

```powershell
> iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
```

```powershell
> choco -v
0.10.8
```

### Install java ###

```powershell
> choco install jdk8
```

```powershell
> java -version
Java version “8.0.152”
```

### Set JAVA_HOME ###

```powershell
> start SystemPropertiesAdvanced.exe
```
and set in env variables JAVA_HOME.

```powershell
> $env:JAVA_HOME
c:/Program Files/Java/jdk-8.0.152
```

### Install intellij idea ###

```powershell
> choco install intellijidea-community
```

### Install maven ###

```powershell
> choco install maven
```

```powershell
> mvn -v
Apache Maven 3.5.2
```

### Install Chrome ###

```powershell
> choco install googlechrome
```

### Install Chrome Extensions ###

- Ranorex Selocity https://www.ranorex.com/selocity/browser-extension.html

### Download chromedriver ###

```powershell
> choco install selenium-chrome-driver
```

```powershell
> chromedriver
Starting ChromeDriver 2.33.506106 (8a06c39c4582fbfbab6966dbb1c38a9173bfb1a2) on port 9515
Only local connections are allowed.
```

### Install git ###

```powershell
> choco install git
```

```powershell
> git --version
git version 2.15.1
```


## Setup project ###

### Create folder ###

```powershell
> mkdir C:/git
> cd C:/git
```

### Clone repo ###

```powershell
> git clone https://github.com/ilyubin/2018.01.pflb.school.git
```

### Open in IDE ###

`File` > `Open...`

### Check JDK ###

Check `File` > `Project Structure...` > `Platform Settings` > `SDKs`. If empty - add your installed `jdk` here.

## Run tests ##

### IDE run in Chrome ###

Open test file `*Story.java` and just click green triangle

### Terminal run in Chrome ###

```powershell
> mvn clean verify -Dwebdriver.driver=chrome
```
### Terminal run in Chrome ###

```powershell
> mvn clean verify -it.test=PurposeStory#create_purpose
```

## Structure ##

### About project ###

```powershell
ok.automation
├── features
├── pages
├── steps
└── tech
```

- `features` - tests, here test-logic, it use `steps`
- `steps` - here business-logic, it use `pages`
- `pages` - here technical-realisation, it use locators, selenium/serenity commands
- `tech` - helpers, extensions and other technical stuff


## How to create new tests ##

Just add one file to each package.

For example: we write tests for `purpose`.

It need create:

- in `features` file `PurposeStory` that extends from BaseFeature. Always start from test-design. In `PurposeStory` put a set of blank test how-to create, read, update, delete (CRUD) + search `purpose`

```java
public class PurposeStory extends BaseFeature {

    @Steps
    private PurposeSteps _purpose;

    @Before
    public void open_purpose_page() {
        _purpose.open_page();
    }

    @Test
    public void create_purpose() {
        // Your test here
    }
}
```

- in `steps` file `PurposeSteps` and implement method `open_page()`. Create other steps for CRUD + search + accessors for make assertions.

```java
public class PurposeSteps implements ISteps {

    CampaignPage campaignPage;
    PurposeListPage listPage;
    PurposeCreatePage createPage;

    @Step
    public void open_page() {
        campaignPage.open();
        campaignPage.openPurposeTab();
    }

    @Step
    public void create_new(PurposeModel purpose) {
        listPage.openCreationForm();
        createPage.fillCreationForm(purpose);
        createPage.submitCreationForm();
    }
    
    // Other steps here
}
```

- in `pages` a set of pages it may be `*ListPage`, `*CreatePage`, `*ImportPopup` etc. Implement all page's methods using selenium/serenity commands

## Links ##

- `serenity` http://thucydides.info/docs/serenity-staging/#introduction
- `assertj` http://joel-costigliola.github.io/assertj/
- how to `git` https://githowto.com/ru
- locators table http://www.cheat-sheets.org/saved-copy/Locators_table_1_0_2.pdf
