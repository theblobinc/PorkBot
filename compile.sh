rm porkbot-1.0-SNAPSHOT.jar
mvn package
mv target/porkbot-1.0-SNAPSHOT.jar ./porkbot-1.0-SNAPSHOT.jar
echo Done! Type ./start.sh to start the bot.
