Analysis of the Problem:

We are given a text file from which we read input in form of x and y co-ordinates of a point.We find out the points which are collinear and print them.

Analysis of Point.java:

To read a input as point ,we create a class Point.java and the object of that class becomes a generic datatype Point.In Point.java file we declare and define compareTo function and slopeTo function to compare two points and find slope between two points.
We also declare Comparator SLOPE_ORDER which is used to sort a given set of points according to the slope they make with one particular point.Another class has been creatd for JPanel.

Analysis of Brute.java:

In Brute.java we are using brute force algorithm to find the collinear points.In this code,we take input from a text file and store that input in form of x and y co-ordinates in an array of points.Then we use 4 for loops to iterate through each point and 
compare them first using compareTo function and terminate that loop using continue keyword when a point is less than other point.We do this because we dont want all sorts of permutations and combinations of the collinear points.Then we find out the slope using slopeTo function and 
then terminate the loop if the slopes are not equal.Thus we find 4 collinear points using all possible combinations of points

Time Complexity: As there are 4 for loops for 4 points , n*n*n*n=n^4.So the Time complexity is O(n^4).

Analysis of Fast.java:

In Fast.java , we are sorting the points first and then finding the slope between two points,comparing the slope and if they are equal ,the points are added to an ArrayList and displayed.Here sort function of Java is used which is merge sort algorithm.
The points are sorted according to the slope they make with an original point p and after that we compare the slopes using slopeTo method,here we are using only 2 loops,as the points are sorted before hand.I also used another boolean function which returns 
true or false depending upon whther a point is in the arraylists specified or not.

Time Complexity:As it is a sorting algorithm and the sort function is merge sort algorithm and the dominant function among n and nlogn is the later one,the Time complexity id O(nlogn).

How to compile the file:

With the java files, the two input files ,one for 6 pairs and one for 8 pairs is also sent,so in the code we can directly give input as input file path,the files are in the same folder.
Or if it doesnt compile saying that the file is not found,the full physical path of the file has to be given.I am sending the whole netbeans project folder , if you are running the project on Netbeans or Eclipse,the whole project can be imported ,if not 
the files in the src folder can be copied to another folder and run in terminal from there.All files are in the package daa.assignment2.

Note:
For drawing the points and lines, I used StdDraw function which is another library which i imported in the java files of Point,Brute and Fast.StdDraw has been created with java swing components.StdDraw.java file is also
included in the folder.For the functions to be implemented and for the code not showing errors for those functions , the file should be in the same folder and library imported in the java file.
Also java.swing and java.awt packages have been imported for display purposes.