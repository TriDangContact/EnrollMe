# EnrollMe
Forked from SoftWhere, our team from Software Engineering course. This project aims to create a course registration web application by following the Agile software development methodology. In particular, it uses the MVC architecture, using Java for the back end, Bootstrap framework for the front end, and MySQL for the database.

# Team
Tri Dang
Pengyu Wang
Hsuan Yu
Miguel Campos

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
