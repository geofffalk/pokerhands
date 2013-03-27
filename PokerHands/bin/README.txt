Here is a short summary of the files and package structure of PokerHands, by Claire Fennell
and Geoff Falk, Assignment 2 of OODP module 2013.


game.cardscoring
----------------

Package responsible for calculating and comparing scores of given hands,
based on analysis from Analyser classes
classes.

Scorer.java - interface file, defining methods to calculate, get, and compare scores in the form
of an array of integers 

HandScorer.java - implementation class for above



game.cardananalysis
-------------------

Package responsible for checking hand of cards for different winning combinations, such as pairs, straights etc. and
retreiving the numerical value of winning combinations

Analyser.java - interface file, defining methods for visiting hands, and storing the values of winning combinations

AbstractAnalyser.java - abstract parent class that implements Analyser, implementing the methods for saving, resetting and
retreiving the values of winning combinations.

FlushAnalyser.java - implements visit method to checks hands for flushes of one suit

MatchAnalyser.java - implements visit method to check for matching cards, for example pairs, two pairs, threes and pokers

StraightAnalyser.java - implements visit method to check hands for straights


game.model
----------

Package containing the model classes related to generating and storing cards and hands, including Card, Hand and Dealer

Card.java - interface file defining methods for getting and setting values and suits, and comparing cards

Hand.java - interface file defining methods for getting, adding and removing cards, as well as retreiving a tally of the
different values contained within the hand

Dealer.java - interface file defining methods for shuffling and dealing a pack of cards.

PokerCard.java - implementation of Card.java

PokerHand.java - implementation of Hand.java

PokerDealer.java - implementation of Dealer.java


game.player
___________

Package containing business logic for how program decides which cards to keep and which cards to discard

Player.java - interface defining single method which returns the indexes of the cards to be discarded

ComputerPlayer.java - implementation of Player.java


game.view
---------

Package containing GUI components

GameFrame.java - defines main GUI components for game 

playerDisplay.java - defines individual panels for each player


game.controller
---------------

Package containing controller classes and main game driver

GameController.java - controls flow of game

GameMain.java - starts Swing thread