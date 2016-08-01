Guidelines
General guidelines:
1.	Follow the instructions in order - do not skip ahead
2.	After each step, commit your changes to GitHub and tag it clearly
3.	There is no fixed time limit for the test but we do not expect to see any extended gaps between commits
4.	Please follow an Object Oriented and TDD based approach
5.	Aim for the simplest solution (i.e. minimal amount of code) which fully solves the problem
6.	We are equally interested in how you tested your implementation as the implementation itself.
When finished, email csongor.zalatnai@moneysupermarket.com and paul.milner@moneysupermarket.com and emma.johnson@oscar-tech.com with the repository location.
Test description
- Create an Apple
- The apple has a colour, weight, taste (allowed values: 1, 2, 3, 4), a flag which indicates whether it has a worm in it
- The apple can weigh between 10g and 100g
- The apple can be either green, red, or blue
- The apple can either be peeled or eaten.
- Before eating the apple, it needs to be peeled.
- An apple can only be peeled if it does not have a worm in it and its taste is > 3
- Green and red apples can be easily peeled by any peeler, but blue apples can only be peeled with a special peeler (Valyrian steel peeler?).
