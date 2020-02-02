• Game table is an N xN table whose cells are ﬁlled with numbers from 1
to (N2− 1), and the remaining one is blank.
• Only the blank box can be moved on the table and the moving direction
can be either horizontal or vertical (diagonal moves are not possible).
• When the blank box is moved, the blank one and the box in the destination
position of the blank box are swapped.

Your program should provide the necessary sequential moves in order to achieve
the goal conﬁguration from the initial conﬁguration, which is given as input.
When solving the problem, you are expected to construct a tree structure. The
root of this tree is the initial conﬁguration of the puzzle given as input to your
program. Then, for every possible move on the conﬁguration that belongs to a
node, you have to create new children nodes and check whether the goal con-
ﬁguration is reached or not. Your program should continue processing until the
node with the goal conﬁguration. But note that, some initial conﬁgura-
tions do not have any solution! 

Your program will run with two arguments. The ﬁrst one will be the name of
the input ﬁle (i.e. the initial conﬁguration of the puzzle) and the other one will
be the name of the output ﬁle. These ﬁles shall be under src directory.
The input ﬁle will contain a single line string of N2 numbers separated by
’-’, where 0 represents the empty cell. For instance, please check the follow-
ing example of an input string that represents the initial conﬁguration of the
corresponding table:
4 6 7
3 2 1
5 8
Table representation of the input string: ”4-6-7-3-2-1-5-0-8”
Your program must write the solution to the output ﬁle in the following format:
• Write all steps without blank spaces or newline characters.
• Starting from the initial conﬁguration, for LEFT move, write letter L
• For RIGHT move, write letter R
• For UP move, write letter U
• For DOWN move, write letter D
At the termination of the program, the output for the puzzle given above should
be the following:
ULURRDLULDRURDLDLUURDDR
which means, starting from the initial conﬁguration, if we move the blank box
UP, LEFT, UP, RIGHT, RIGHT ... then we end up with the goal conﬁguration


• Input: ”1-2-0-3-6-4-5-7-8”, Output: DLLDRRULLURRDLULDRRD
• Input: ”1-2-3-4-5-6-8-7-0”, Output: N
• Input: ”2-10-4-0-1-6-3-7-5-14-12-8-9-13-11-15”,
Output: LDLULDDDRUURRDLDR
• Input: ”1-2-4-5-10-6-7-3-14-9-0-11-12-8-15-16-17-13-18-20-21-22-23-19-
24”,
Output: RRRURULLDDDRDR












































