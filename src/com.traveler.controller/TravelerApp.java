package com.traveler.controller;

import com.apps.util.Prompter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

class TravelerApp {
    private boolean gameOver = false;
    Prompter prompter = new Prompter(new Scanner(System.in));
    SplashScreen screen = new SplashScreen();
    Intro intro = new Intro();


//    initialize calls methods
    public void initialize(){
        welcome();
        promptForNewGame(); // sets gameOver
    }

    // start called from promptForNewGame(), main part of game
    public void start() {
        while (!gameOver) {
            String command = prompter.prompt("What would you like to do?");
            if (command !=null) {
                switch (command){
                    case "quit game":
                        end();
                        break;
                }
            }
        }
    }

    // game end method that handles end of game
    public void end() {
        setGameOver(true);
        System.out.println("GAME OVER");

    }

    private void welcome() {
        screen.splashScreen();
        intro.introduction();
        System.out.println("WELCOME");
    }

    // prompts for new game or saved game
    private void promptForNewGame(){
        String start = prompter.prompt("Would you like to start a new game or continue from save? [N]ew game or [S]saved game: ");
        if (textParse(start).equals("n")) {
            System.out.println("STARTING NEW GAME");
            start();
        } else if (textParse(start).equals("s")) {
            System.out.println("STARTING SAVED GAME");
            start();
        }
        //error handling
        else {
            System.out.println("Please enter valid response, n or s");
            promptForNewGame();
        }
    }

    private String textParse(String input){
        return input.trim().toLowerCase();
    }

    // TODO: create verb Parser
    private String verbParse(String input) {

        return input;
    }

    //TODO: create noun parser

    //Getter and setter

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}