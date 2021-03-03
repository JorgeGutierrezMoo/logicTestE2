# logicTestE2

This project is made using IntelliJ IDEA in Kotlin language.

    Clone the project or Download the zip file.

    https://github.com/JorgeGutierrezMoo/logicTestE1
    
    If using terminal: clone the project use the "clone". It will look like: $ git clone https://github.com/JorgeGutierrezMoo/pokemonk.git
    There is also a GUI option named SourceTree to clone project in a clearer way.

    Verify that IntelliJ IDEA is installed in the PC. If not, please install.

    Open AIntelliJ IDEA.
    Select "Open an existing project"
    Locate the path where you saved the project, either by downloading the zip or by cloning the repository.
    Select the project name as "logicTestE1-master".
    Wait until the Android Studio IDE finishes building the project. (You can tell it is still buildind if in the bottom part of the IDE you can see text showing and changing).
    At the top part of the IntelliJ IDEA you will see a green triangle. If you put the mouse over it will display a text saying "Run App". Click it.
    The console will open and will ask you for a proper input. Be sure to put input in the right way:
    Examples:
    517BC-144AC  Years in this format can go from 753BC to 2021AD.
    753BC-747AC  
    2000AD-2012AD
    
    The output will be an integer number.
    
---------------------------------------------

Solve the following using Kotlin

A well-known software development company has been commissioned by the Archaeological Society. 
One of the modules has to help the archaeologists to process data about the ruins of buildings they have found during their excavations of ancient cities.
Development of this module has been assigned to Vasya.
Vasya, being a seasoned programmer, at once noticed that the module would need a database to contain the descriptions of the ruins and the estimated construction times of the buildings.
It would be all fine, but suddenly the manager got the genial idea that since the database describes Roman ruins, the years of construction should be stored in the Roman number system.
Now Vasya is wondering how many symbols he needs to set aside for each year number field in the database.
According to the functional specification, the software module must be able to handle years from A to B (inclusive). Help Vasya determine the minimal number of characters sufficient for storing any year number in the range from A to B.

Especificación de entrada

The only input line contains the descriptions of the years A and B, separated by the "-" sign.
A description of a year consists of one to four decimal digits (the number of the year), followed by either "AD" (Anno Domini, the current era) or "BC" (Before Christ, before the current era).
In both directions the years are numbered starting from 1. It is known that (753BC) <= A <= B <= (2012AD).

Especificación de salida

The output should consist of a single integer, the minimal number of characters that have to be reserved in the database for the year number.
Ejemplo de entrada

1BC-1AD
Ejemplo de salida

7
Hint(s)

For input:

753BC-747BC

Output must be:

3

For input:

2000AD-2012AD

Output must be:

10

