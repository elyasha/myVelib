# myVelib
Final project of Oriented Object programming at CentraleSupélec

# Documentation
The documentation of this project is available [here](https://elyasha.github.io/myVelib/)

# Coverage report
The coverage report of this project is available [here](https://elyasha.github.io/myVelib-coverage/)


# Pre-requisites
- jdk 11

# 1 Overview
A bicycle sharing system (like, for example, Velib in Paris) allows inhabitants to rent bicycles
and cycle around a metropolitan area. Such a system consists of several interacting parts
including: the renting stations (displaced in key points of a metropolitan area), dierent
kind of bicycles (mechanical and electrically assisted), the users (which may posses a reg-
istration card), the maintenance crew (responsible for collecting/replacing broken down
bicycles), etc.

# 2 Requirements (core application)

## 2.1 Components of my Velib system
- [x] Station : a station is where bicycles can be ``rented`` and ``dropped``. It consists of a
                number of ``parking slots`` where bicycles are stored and of a ``terminal`` which users can 
                interact with in order for ``renting bicycles``. Parking slots can be be occupied by a
                ``bicycle``, ``free`` or ``out-of-order``. A station is located in a specific place specified by ``GPS
                coordinates``. A station can be ``on service`` or ``offine``: if it is offine all of its parking
                bays as well as the terminal cannot be used. There exist two types of ``stations``,
                a ``standard`` type, and a ``plus`` type. When a user who hold a Velib card drops a
                bicycle to a ``plus`` station it earns ``5 minutes credits`` in its ``time balance``. Each station
                has a ``unique numerical ID`` and so each parking slot (within a station) has a unique
                numerical ID.

- [x] Bicycle : there exists two kind of bicycles, ``mechanical`` and ``electrical``. Each bicycle
                has a unique numerical ID.
- [x] User : has a ``name``, a ``unique numerical ID``, a ``geographical position`` (GPS coordinates)
             a ``credit card`` and might have a ``registration card``. In case a user holds a card she has
             also a ``time-credit balance`` (expressed in minutes) representing the credit gained by
             returning bicycles to "plus" stations. The time credit is used to compute the actual
             cost of a bicycle ride. The user has also a ``balance of total charges`` representing the total
             amount of money she has been charged for using bicycle of the myVelib system.
- [x] Cards : there are two kinds of registration cards: ``Vlibre`` and ``Vmax``

## 2.1.1 Cost for using the bicycles
On returning of a velib to a station the system will (automatically) compute the corresponding cost of the ride based on the ride duration (in minutes), the kind of bicycle, and on
the type of card a user has.

- [x] if a user has ``no card`` the cost is ``1 Euro per hour (for mechanical bicycles)`` and ``2 Euro
per hour (for electrical bicycles)``
- [x] if a user has a ``Vlibre`` card the cost is: ``0 Euro for the first hour then 1 euro per each
successive hour (for mechanical)`` and ``1 Euro for the first hour then 2 euros per each
successive hour (for electrical bicycles)``. If a ride lasts longer than 60min the actual
time balance exceeding 60min is computed by deducing from the user's time-credit
(if any). For example a user's time-credit is 20min and the ride lasts 75min, then the
user won't be charged any extra min (beyond 1h) but it's time-credit will be updated
to 5min (deducing the 15min in excess to the free hour). On the other hand if the
ride lasts 135min, the user will be charged for 135-20 = 115min, hence for the 55min
in excess of an hour, and so on.
- [x] if a user has Vmax card the cost is: 0 Euro for the first hour then 1 euro per each successive
hour (independently of the kind of bicycle)

## 2.2 Rides planning

- [x] The myVelib system must be equipped with a functionality that helps users to plan a ride
from a starting location to a destination location. Given the starting and destination GPS
coordinates the ride planning functionality will identify the \optimal" start and end stations
from/to where the bicycle should be taken/dropped according to the following criteria:

- [x] the start, respectively the end, station, for a ride should be as close as possible to
the starting, respectively to the destination, location of the ride.
- [x] the start station should have one bicycle of the desired kind (electrical or mechanical)
available for renting
- [x] the end station should have at least one free parking slot.

OPTIONAL ride-planning policies
- [ ] avoid ``plus`` stations: like minimal walking distance but return station cannot be
a ``plus`` station
- [ ] prefer ``plus`` stations: with this policy the return station should be a ``plus``
station (given a ``plus`` station no further away than 10% of the distance of the
closest station to the destination location exists). If no such a ``plus`` station exists
then this policy behaves normally (as a minimal walking distance).
- [ ] preservation of uniformity of bicycles distribution amongst stations: with
this policy the choice of the source and destination station is aected by the number
of available bicycles (at source station) and free slots (at destination). Specifically, let
s0 be the closest station to the starting location with at least one available bicycle of the
wanted kind, and sd be the station closest to the destination location with at least
one free parking slot. Then if a station s0
0 whose distance from the starting location
is no more than 105% the distance of s0 from the start location has a larger number
of bicycles (of the wanted kind) than those available at s0 it should be selected in place
of s0. Similarly if a station s0
d (whose distance from the destination location is at
most 105% of the distance of sd from the destination location) has a larger number
of free parking slots than sd it should be selected as the destination station in place
of sd.

## 2.3 Rental and returning a bicycle

- [x] To rent a bicycle a user must get to one station, identify herself (either through a velib-card
or through a credit-card) and pick up one of the available bicycles. A user can only rent at
most one bicycle (i.e. if she has a bicycle and has not yet returned it, she cannot rent a
second one). To return a bicycle a user must park it to a free (and on-duty) parking bay
of some station. When the bicycle is returned the cost for the ride is computed and user is
automatically charged (if a charge applies).

## 2.4 Computing statistics and sorting of stations

The myVelib system should support the following functionalities for computing relevant
statistics:

### User balance

- [x] The number of rides
- [x] the total time spent on a bicycle
- [x] the total amount of charges for all
     rides performed by a user
- [x] the time-credit earned by a user
 
### Station balance

- [x] total number of rents operation,
- [x] return operations performed on the station.
- [ ] It should also allow to compute the average rate of occupation of a given station over a given time window
````shell
for [ts, te] with delta = te - ts; 
The rate of occupation of a station is given by:

rate = (sum(i=1, numberOfParkingSlots, ti ^ delta) / (delta * numberOfParkingSlots);

````
where N is the number of parking slots in the station, ti
is the time the i-th slot
has being occupied during the time window [ts; te]. Notice that in the computation
of occupation rate of a station if a parking slot is out-of-service then it should be
accounted as being occupied (independently of whether it holds a bicycle or not).





Furthermore myVelib should support different policies for sorting stations including
those based on the following criteria:

- [x] most used station: stations are sorted w.r.t. the total number of renting + dropping operations
- [ ] least occupied station: stations are sorted w.r.t. the rate of occupation (ratio
between free time over occupied time of parking bays). This allows for figure out
policy to increase the use of less occupied stations (for example by electing the least
occupied stations to the ``plus`` category so to attract users to drop bicycles).

Remark (``an OPEN-CLOSE solution``). Your design should match as much as possible
the open-close principle. Using of design patterns should be properly documented in the
project report explicitly describing to fulfil which requirement of the myVelib system a
design pattern has been applied.

## 2.5 Use case scenario
In order to further guide you in the process of designing/developing the core infrastructure
for the myVelib system you should take into account the following use case scenario which
describe a few examples of realistic interactions between the user of the myVelib system
and the myVelib framework.

### Setting up of myVelib
- [x] The user sets up an instance of the myVelib system: he/she create a myVelib with N
stations, summing up to a total of M parking slots, the 70% of which is occupied by
available bicycles (30% of which are electrical the rest mechanical). The N stations
should be placed randomly (in a uniform manner) over a square surface of area 1010
square kilometres (roughly the surface of Paris intramuros).
- [x] The user add some user to the myVelib system some of which are card holder, some
not.
### Rental of a bicycle

- [x] a user (card holder or not) rent a bicycle of a given type from a given station at a given
moment in time
- [x] the user returns the bicycle to another station after a given duration (expressed in
minutes).
- [x] the user get charged for the corresponding amount (possibly 0) and possibly receive
a time-credit (possibly 0)

### Visualisation of user, station and system state

- [x] a manager (or a user) of myVelib request to see the current state of a user with given
ID
- [x] the system displays a report of the requested user (including its balance, time credit,
number of rides, etc).
- [x] a manager (or a user) of myVelib request to see the current state of a station with
given ID
- [x] the system displays a report of the requested station (including num. of free/occupied
slots, current state, its occupation etc)
- [x] a manager (or a user) of myVelib request to see the current state of a the entire
system
- [x] the system displays a summary report of the system (including list of online/oine
stations, list of users of myVelib , etc.)

### Simulation of a planning ride

- [x] a user at a given position require a ride planning to reach a destination position
- [x] the user receives the source and destination stations
- [x] the user retrieve a bicycle from the source station of the planned ride at a given
instant of time
- [x] the user that is holding a bicycle returns it (in a given free slot) at a given station at
a given instant of time.

### Computation of statistics
- [x] the myVelib system stores relevant data in form of records representing N rental bicycle
simulations (by dierent users, on dierent stations, and with dierent duration)
- [x] the statistics (computed w.r.t. the rental records added in previous step) for each
user are displayed
- [x]  the statistics (computed w.r.t. the rental records added in previous step) for each
station are displayed
- [x] stations are displayed sorted w.r.t. the most used station (first)
- [ ] stations are displayed sorted w.r.t. the least occupied station (first)


# 3 Part 2: myVelib user interface

The part 2 of the project is about realising a user interface for the myVelib-app. The
user interface consists a command-line user interface (CLUI). [For insights about CLUI
see](https://en.wikipedia.org/wiki/Command-line_interface) and some examples in
[Java](https://dzone.com/articles/java-command-line-interfaces-part-29-do-it-yoursel)

## 3.1 myVelib CLI: Command line (user) interface

The command line interpreter provides the user with a (linux-style) terminal like environment to enter commands to interact with the myVelib core. A command consists of the
command-name followed by a blank-separated list of (string) arguments:
````shell
command-name <arg1> <arg2> ... <argN>
````

a command without argument is denoted ``command-name <>``.

For example the myVelib CLI command for setting up a myVelib system consisting of 10
stations each of which has 10 parking bays and such that the initial population of bicycle
is 75% of the total number of parking bays in the system would be as follows:

````shell
setup 10 10 0.75
````

The list of commands supported by the myVelib CLI must include the following ones:

- [x] ``setup <velibnetworkName>``: to create a myVelib network with given name and
consisting of 10 stations each of which has 10 parking slots and such that stations
are arranged on a square grid whose of side 4km and initially populated with a 75%
bicycles randomly distributed over the 10 stations
- [x] ``setup <name> <nstations> <nslots> <s> <nbicycles>``: to create a myVelib net-
work with given name and consisting of nstations stations each of which has nslots
parking slots and such that stations are arranged in as uniform as possible manner
over an area you may assume either being circular of radium s or squared of side s
(please document what kind of area your implementation of this command takes into
account and how stations are distributed over it).Furthermore the network should
be initially populated with a nbicycles bicycles randomly distributed over the nstations
stations
- [x] ``addUser <userName,cardType, velibnetworkName>``: to add a user with name
userName and card cardType (i.e. ``none'' if the user has no card) to a myVelib net-
work velibnetworkName
- [x] ``offline <velibnetworkName, stationID>``: to put oine the station stationID
of the myVelib network velibnetworkName
- [x] ``online <velibnetworkName, stationID>``: to put online the station stationID of
the myVelib network velibnetworkName
- [x] ``rentBicycle <userID, stationID>``: to let the user userID renting a bicycle from station
stationID (if no bicycles are available should behave accordingly)
- [x] ``returnBicycle <userID, stationID, time>``: to let the user userID returning a bicycle
to station stationID at a given instant of time time (if no parking bay is available
should behave accordingly). This command should display the cost of the rent
- [x] ``displayStation<velibnetworkName, stationID>``: to display the statistics (as of
Section 2.4) of station stationID of a myVelib network velibnetwork.
- [x] ``displayUser<velibnetworkName, userID>``: to display the statistics (as of Sec-
tion 2.4) of user userID of a myVelib network velibnetwork.
- [x] ``sortStation<velibnetworkName, sortpolicy>``: to display the stations in increas-
ing order w.r.t. to the sorting policy (as of Section 2.4) of user sortpolicy.
- [x] ``display <velibnetworkName>``: to display the entire status (stations, parking bays,
users) of an a myVelib network velibnetworkName.

- [x] to be completed ... (the help command and exit command)

It should be possible to write those commands on the CLUI and to run the com-
mands in an interactive way: the program read the commands from testScenarioN.txt
(see Section 4.2), pass them on to the CLUI, and store the corresponding output to
testScenarioNoutput.txt.

### Error messages and CLI: 

- [x] The CLUI must handle all possible types of errors, i.e.
                              syntax errors while typing in a command, and misuse errors, like for example trying to
                              rent a bicycle from a station which is oine or that has no available bicycles.

# 4 Project testing

In order to evaluate your implementations we (the Testers of your project) require you (the
Developers) to equip your projects with both standard Junit tests (for each class) and
a test scenario, described below. Both JUnit tests and the test scenario are mandatory
parts of your project realisations, as we (the Testers) will resort to both of them to test
your implementations.

## 4.1 JUnit tests

Each class in your project must contain JUnit tests for the most significant methods (i.e.
excluded getters and setters).
``Hint``: if you follow a ``Test Driven Development`` approach you will end up naturally having
all JUnit tests for all of your classes.

## 4.2 Test scenario

In order to test your solution you are required to include in the project
- [x] one initial configuration file (called my velib.ini), automatically loaded at starting
of the system,
- [x] at least one test-scenario file (called testScenario1.txt).

``Configuration file``: An initial configuration file must ensure that, at startup (after loading this file) the system contains at leas the \standard" setup corresponding to the default
version of the CLI command setup.

``Test-scenario file``: A test-scenario file contains a number of CLUI commands whose
execution allows for reproducing a given test scenario, typically setting up a given config-
uration of the myvelib system (i.e. creation of some velib network, adding of some users,
simulation of some rental/returning of bicycles, simulation of planning of a ride, computation
of statistics for the stations and the users, etc.). You may include several test-scenario
files (e.g. testScenario1.txt, testScenario2.txt, ...). For each test-scenario file you
provide us with you MUST include a description of its content (what does it test?) in the
report. We are going to run each test-scenario file through the runtest command of the
CLUI (see CLUI commands above):

````shell
runTest testScenario1.txt
````
