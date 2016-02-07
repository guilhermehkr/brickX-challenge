# brickX-challenge

## This program should be run using unit test classes.

Firstly, go to test resources folder and paste there file should be tested.

Secondly, go to SpecsSetup object and insert your file name into yourFileName constant.

After these steps, run command 'test' using sbt terminal or through your IDE, it's up to you!

I decided by:

- While file is reading, some validation are done and if there is something wrong in the rover entry, this rover will be marked as invalid and won't
be processed
- When it founds at least one wrong command ( something not like Left, Right and Movement ), this rover will be marked as invalid
- When rovers goes out of plateau, it will be marked as invalid

### Why did I do like this? I don't know, I thought it reasonable!


# I hope you like it and enjoy yourself.

Ps.: This program does not take care of rovers in the same spot AND file must always have a couple of lines for one rover,
otherwise it'll be a messy, unfortunately!