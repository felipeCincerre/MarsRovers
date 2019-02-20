--= HOW TO EXECUTE IT? ---
Extract files, import the project on your IDE.

->To execute
Go to ProblemTwoMarsRovers\src\Principal
Right Button on Principal.java-> Run As-> Java Application
Note: Sometimes is needed to use alt+tab to find the input dialog on the screen

->To test
Go to ProblemTwoMarsRovers\src\Teste
Right Button on RoverTeste.java-> Run As-> JUnit test

--- HOW IT WORKS? ---

First of all, I defined the upperMargin coordinates as xSuperior and ySuperior.
Both variables must be Integer, so I used JOptionPane inputDialog to display a textField on the screen. 
After typing the value for xSuperior or ySuperior, you can click on "OK" button or just press enter. Then a validation is called to validate xSuperior or ySuperior, in case it cannot convert the value to Integer, the system will throws a NumberFormatException.

In case the values are valid, appears new text fields to type values for x and y coordinates of the first rover. A validation is called to verify if it is possible to convert these values to Integer.
If it cannot convert, a NumberFormatException is thrown.

Passing through these validations, the next step is to set where the rover is facing. The system will ask to type N for North, E for East, S for South and W for West. A validation is called to verify if the user typed one of these letters, if not, an IllegalArgumentException is thrown.

Finally is time to set the instructions. Will be asked to type L for Left, R for Right or M for Move the rover. A validation is called to verify if the user typed one of these letters, if not, an IllegalArgumentException is thrown.

If everything typed is correct, the system starts to execute the instructions.

The method andar will receive a string and will get every char of it and send to mudarPosicaoRobo.
MudarPosicaoRobo verify if the char is L, R or M.
- Case L, it will be verified the current direction of the rover. If the current direction less 1 will be lesser than North value(1), the new direction of the rover will be West value(4). Else, the new direction will be current direction value minus 1.

- Case R, it will be verified the current direction of the rover. If the current direction plus 1 will be higher than West value(4), the new direction of the rover will be North value(1). Else, the new direction will be current direction value plus 1.

- Case M, it will be verified the current direction of the rover. 
	- If current direction equals North Value(1):
	Will be verified if y is equal or higher than ySuperior. If true throws exception, the rover cannot go beyond the upper margin. Else, the new y will be the current y plus 1.

	- If current direction equals East Value(2):
	Will be verified if x is equal or higher than xSuperior. If true throws exception, the rover cannot go beyond the upper margin. Else, the new x will be the current x plus 1.

	- If current direction equals South Value(3):
	Will be verified if y is equal or lesser than 0. If true throws exception, the rover cannot go beyond the bottom margin. Else, the new y will be the current y minus 1.

	- If current direction equals West Value(4):
	Will be verified if x is equal or lesser than 0. If true throws exception, the rover cannot go beyond the bottom margin. Else, the new x will be the current x minus 1.

After all instructions had been executed, a MessageDialog will show the final position of the rover.

Then, if pressed "OK", an InputDialog will ask for the position of the second rover and the process will be repeated.

--- JUnit Tests ---
6 JUnit Tests were created:

- testarPrimeiroRobo:
Use the data showed in the programming problem (xSuperior=5; ySuperior=5; x=1; y=2; direcao=N; instrucoes="LMLMLMLMM") for the first rover. 
Expects the same output in the programming problem (x=1; y=3; direcao=N)

- testarSegundoRobo:
Use the data showed in the programming problem (xSuperior=5; ySuperior=5; x=3; y=3; direcao=E; instrucoes="MMRMMRMRRM") for the second rover. 
Expects the same output in the programming problem (x=5; y=1; direcao=E)

- testarUltrapassandoNorte:
Use the following data (xSuperior=5; ySuperior=5; x=1; y=2; direcao=N; instrucoes="LMLMLMLMMMMM") to trespass xSuperior. 
Expects IllegalArgumentException, informs that the rover cannot go North because will trespass xSuperior.

- testarUltrapassandoLeste:
Use the following data (xSuperior=5; ySuperior=5; x=3; y=2; direcao=E; instrucoes="LMLMLMLMMMMM") to trespass ySuperior. 
Expects IllegalArgumentException, informs that the rover cannot go East because will trespass ySuperior.

- testarUltrapassandoSul:
Use the following data (xSuperior=5; ySuperior=5; x=1; y=2; direcao=S; instrucoes="LMLMLMLMMMMM") to trespass x.  
Expects IllegalArgumentException, informs that the rover cannot go South because will trespass x.

- testarUltrapassandoNorte:
Use the following data (xSuperior=5; ySuperior=5; x=1; y=2; direcao=W; instrucoes="LMLMLMLMMMMM") to trespass y. 
Expects IllegalArgumentException, informs that the rover cannot go West because will trespass y.