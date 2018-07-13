find . -name "*.class" -delete
find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java src.simulation.simulator.Simulator src/scenario.txt