###########
PlatoonBattleWin application
Expecting java cmd arguments of inputs as below:

ARG 1 : Our Army string 
	Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120
ARG 2 : Opponent Army string 
	Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120

ARG 3 :Platoon seperator - in the above example patoon seperator is semicolan  ;
ARG 2 :typecount separator - in the above example patoon seperator is #

Sample Input:
Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120
Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100
;
#
Sample Output: (can vary)
Militia#30;FootArcher#20;Spearmen#10;LightCavalry#1000;HeavyCavalry#120


User Story:

Problem statement:

Scenario:

You are a medieval king attacking your opponent at five locations simultaneously
Each location has a platoon - which has a number of soldiers of a specific class
You know the platoons your opponent has
Your job is to figure out which of your platoons should attack which of your opponent's platoons so that you can win majority of the battles.

In general, one soldier of your platoon will be able to handle one soldier of your opponent's platoon
If your platoon has 100 soldiers and your opponent's platoon has:
* 99 soldiers - You Win
* 100 soldiers - Draw
* 101 soldiers - You Lose
Platoon Classes
There are 6 classes of soldiers:
- Militia
- Spearmen
- Light Cavalry
- Heavy Cavalry
- Foot Archer
- Cavalry Archer

Each class of soldier has an advantage over other classes of soldiers
Unit Class Advantage Over
Militia -> [ Spearmen, LightCavalry ]
Spearmen -> [ LightCavalry, HeavyCavalry ]
LightCavalry -> [ FootArcher, CavalryArcher ]
HeavyCavalry -> [ Militia, FootArcher, LightCavalry ]
CavalryArcher -> [ Spearmen, HeavyCavalry ]
FootArcher -> [ Militia, CavalryArcher ]


The soldiers who have advantage over the opponent, will be able to handle twice the amount of opponent's soldiers
If your platoon has 100 Spearmen and your opponent's platoon has:
* 199 HeavyCavalry - You Win
* 200 HeavyCavalry - Draw
* 201 HeavyCavalry - You Lose

The input to the problem statement is the list of platoons that you have with their classes and number of units in the first line
The second line contains the list of platoons of the opponent (PlatoonClasses#NoOfSoldiers)
Spearmen#10;Militia#30;FootArcher#20;LightCavalry#1000;HeavyCavalry#120
Militia#10;Spearmen#10;FootArcher#1000;LightCavalry#120;CavalryArcher#100
