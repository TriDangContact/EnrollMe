# Setup #

## Mac ##
```
# install homebrew
$ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

# install sbt
$ brew install sbt@1
```

## PC ##
Install sbt from [https://www.scala-sbt.org/download.html]

# Database #
```
mysql -u root -p
```
```mysql
CREATE DATABASE enrollme;
CREATE USER 'softwhere'@'localhost' IDENTIFIED BY 'cs532';
GRANT ALL PRIVILEGES ON enrollme.* TO 'softwhere'@'localhost';
FLUSH PRIVILEGES;
```

# Run #
```
$ sbt run
```
