## MovieApp


## Project Overview

This project aims to demonstrate the usage of Android Architecture Components and how this components can be used in an application with a MVVM architecture in Kotlin 

## Project Description

First of all, I would like to show how I made the packages structure of the project For achieving The separation of concerns 


- ## Presentation layer 
    The Activities, Fragments and ViewModels.
- ## Domain layer 
    With the Use Cases
- ##  Data layer 
    With the Repositories.


## What is Architecture Components ? 

Architecture Components are a set of Android libraries for structuring your app in a way that is robust, testable, and maintainable
<p align="center">
<img src="arccomponents.png" alt="" width="480" height="480"/>
</p>


## UI Controllers  
are activities or fragments. The only job of UI controllers is to know how to display data and pass on UI events, such as the user pressing a button. UI Controllers neither contain the UI data, nor directly manipulate data.

## ViewModels and LiveData 

These classes represent all of the data needed for the UI to display. You'll learn exactly how these two classes function together in this codelab.

## Repository 

This class is the single source of truth for all of our app's data and acts as a clean API for the UI to communicate with. ViewModels simply request data from the repository. They do not need to worry about whether the repository should load from the database or network, or how or when to persist the data. The repository manages all of this. As part of this responsibility, the repository is a mediator between the different data sources. You'll learn a lot more about repositories when you make one in this codelab.

## Remote Network Data Source 

Manages data from a remote data source, such as the internet.
Model - Manages local data stored in the database.

