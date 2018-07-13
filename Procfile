web: undle exec thin start -R ./config.ru -e production -p 11400
web: java -jar target/beta-0.0.1-SNAPSHOT.jar
web: lein run -m BetaApplication.java $PORT
orker:  bundle exec rake jobs:work