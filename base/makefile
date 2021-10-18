Main.class: Main.java Practice.class Modified.class Stock.class
	 javac -g Main.java


Practice.class: Practice.java Dirtbike.class
	javac -g Practice.java


Modified.class: Modified.java Dirtbike.class
	javac -g Modified.java


Stock.class: Stock.java Dirtbike.class
	javac -g Stock.java


Dirtbike.class: Dirtbike.java
	javac -g Dirtbike.java


run: Main.class
	java Main

clean: 
	rm *.class
