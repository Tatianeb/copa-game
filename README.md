# copa-game
Clojure Microservice Copa Game: Components, Reiti and Schema

## About this project

Microservice that helps to determine which games will be on the podium and who is the grand champion. 
The result of each match is determined according to the rating of the public for each of the games.

### Structure
The World Cup of Games works as follows: an initial list of 8 games is selected and, among these games, matches are held to find the winner.
To mount the switch is necessary:

• Sort the games alphabetically;
• Make games compete in playoffs as follows: the game in the first position will compete against the one in the last position, the second with the second to last one, and so on.;

#### Elimination Phase
From this stage onwards it is necessary to perform matches between games. Match is a contest between two games, where the game with the highest score is the winner. 
If there are disputes between games with the same score,use the tie-breaking criteria described.

# Repl
To open a nrepl
```bash
clj -M:nrepl
```

## Running the server
First you need to have the database running, for this you can use the docker command in the step above.

### Repl
You can start a repl open and evaluate the file `src/microservice_boilerplate/server.clj` and execute following code:
```clojure
(start-system! (build-system-map))
