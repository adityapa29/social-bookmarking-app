## thrill.io
An MVC-architecture-based social bookmarking application built using Java.

## Project Structure
<img src = "https://user-images.githubusercontent.com/43026075/126900828-b0014b6f-4668-4988-b9c9-0a65187cadf5.PNG" width = "300px" height = "350px"/>

### 1. entities package contents
The com.adityapandey.thrillio.entities package contains below classes:- 

* User  
We can have 3 types of Users for thrill.io - User, Editor, and Chief Editor.
User privileges: A user can decide whether to bookmark a movie, a book, or a weblink from the data available in the DataStore class. 
The decision is made based on a randomized function. The max limit on the bookmarks one user can make is 5. <br>
Editors/Chief-Editors privileges: Just like a regular user, an editor or chief editor can also make bookmark decisions. They can also approve/reject a bookmark as kid-friendly. Editors/Chief-Editors can also decide to share kid-friendly bookmarks (only books, weblinks) with partner websites.

* Bookmark <br> 
Bookmark is an abstract class that is extended by Book, Movie, and WebLink classes. The sub-classes provide their implementation for the abstract method - isKidFriendlyEligible() present in the Bookmark class.

* Movie <br>
Movie class extends the Bookmark class and it provides its own implementation for the abstract method isKidFriendlyEligible() from Bookmark class. Movie-related bookmarks cannot be shared with partner websites and hence this class does not implement the Shareable interface.

* Book <br>
Book class extends the Bookmark class and it provides its implementation for the abstract method isKidFriendlyEligible() from Bookmark class. Book-related bookmarks can be shared with partner websites and hence this class implements the Shareable interface and provides the implementation for the getItemData() method.

* WebLink <br>
WebLink class extends the Bookmark class and it provides its implementation for the abstract method isKidFriendlyEligible() from Bookmark class. WebLink related bookmarks can be shared with partner websites and hence this class implements the Shareable interface and provides the implementation for getItemData() method.

* UserBookmark <br>
This class maintains the relationship between a User and a Bookmark. If a user decides to bookmark, then that information is stored in this class.

Note: The isKidFriendlyEligible() method is implemented using TDD (Test Driven Development) for all the sub-classes of Bookmark and the unit tests are written using J-Unit.

## 2. Program flow
* For running thrill.io, go to com.adityapandey.thrillio package and run the Launch.java class. 
* Internally the main method will make a call to loadData() method. The loadData() method will load the data into our data structures - users and bookmarks.
The loadData() method is making use of the DataStore class to populate the data structures.
* The "users" data structure is a 1-D array and it stores User objects. The "bookmarks" data structure is a 2-D array and it stores WebLink, Movie, and Book objects.
* After loadData() method start() method will be called, which internally makes a call to browse() method. The browse() method simulates a User browsing through the internet and deciding on bookmarking.
* If the user is an editor/chief-editor, he can further decide to mark a bookmark as kid-friendly using the isKidFriendlyEligible() method.
* If a bookmark is marked as kid-friendly then an editor/chief-editor can also decide to share the bookmark with partner websites only if the bookmark is a book or a movie.

## 3. Project extension
__IOUtil.java class__ <br>
A new package com.adityapandey.thrillio.util is added. This package contains a new class IOUtil.java. The IOUtil.java class will read data from the text files - User, WebLink, Movie, and Book using BufferedReader class from java.io package.
This extension allowed us to separate our input data from the DataStore class making our application more loosely coupled. 

## Acknowledgement
Java In-Depth: Become a Complete Java Engineer! course by Dheeru Mundluru


