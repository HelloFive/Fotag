NAME = "Fotag"

all:
	@echo "Compiling..."
	#javac a3/*.java a3/Model/*.java a3/View/*.java
	javac *.java Model/*.java View/*.java

run: all
	@echo "Running..."
	#java a3/$(NAME)
	java $(NAME)

clean:
	#rm -rf a3/*.class
	#rm -rf a3/Model/*/*.class
	#rm -rf a3/View/*/*.class

	rm -rf *.class
	rm -rf Model/*.class
	rm -rf View/*.class