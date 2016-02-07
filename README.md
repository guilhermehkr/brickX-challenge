# brickX-challenge

## This program should be run using unit test classes.

Firstly, go to **test resources** folder and paste there file should be tested.

Secondly, go to **SpecsSetup** object and insert your file name into yourFileName constant.

However, you can use my file as model. Just run and enjoy!

After these steps, run command 'test' using sbt terminal or through your IDE, it's up to you!

I decided by:

- While file is reading, some validations are done and if there is something wrong in the rover entry, this rover will be marked as invalid and won't
be processed
- When it is found at least one wrong command ( something not like Left, Right and Movement ), this rover will be marked as invalid
- When rover goes out of plateau, it will be marked as invalid

### Why did I do like this? I thought it was reasonable and a good solution!


# I hope you like it and enjoy yourself ;)

Ps.: This program does not take care of rovers in the same spot AND file must always has a couple of lines (first line: coordinate + heading, second line: commands) for each rover, otherwise it'll be a messy, unfortunately!

Next steps:
* Check if the next spot is busy
* Check if the number are numbers or just strings, otherwise a ClassCastException will be raise
* Improve my functional style
