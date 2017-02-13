# Screenscrape
A Console Application which hits a target default url but alternative can be supplied as a command line argument.

To Build:
mvn clean build

To Run: 
java target.classes.org.screenscrape.ConsoleApplication

Tests will automatically be run.

Future Enhancements:
BDD Tests in Spock will assist maintenance / enhacements of the project.
Make the individual product page fetches ocurr in parallel
handle returning json exceptions better
