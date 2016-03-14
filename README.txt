CS 349 A3: Fotag!		by Sang Min Park, 20339192
=========================================

How to use 'makefile':
        make all    : this will compile the Fotag
        make run    : this will compile and run the Fotag
        make clean  : this will clean all .class files.


=========================================


Here are the features of this paint program, Doodle.

- GridView by Pressing GridViewButton on top left corner.  Also layouted as required.
- ListView by Pressing ListViewButton on top left corner.  Also layouted as required.
- In no cases, horizontal bar appear.
- Load a picture or multiple pictures at once by pressing LoadButton and choosing file(s) of images
  (Please note that this process will be slow if you have chosen multiple files)
- You can rate each images by clicking one of the star buttons below the image.
  (Please note, this process are slow and will take some time to display current rate of the image)
- By Pressing, one of the stars, pictures will be filtered depending on the rate you choose.
  If you choose, 3-star rate, any images with 3-star rate or above will be listed on display box
  (Please note that, in case this feature does not work properly, click one of any viewButton you like.
   after that, it would work properly.)
- Each images has it's name and date of last modified(created) as it's metadata
- Click on an image to zoom in with 800x600 size of new frame.
  Click on exit button to exit the new frame with corresponding image.
- Resizing is possible, but number of columns will change once you re-click view buttons in GridView after resizing the frame.
- This program is built based on MVC structure


=========================================

COMMENTS for grader.

I have noticed, this program needs some times when loading images, showing display according to your rate choice.
Please wait for a bit to show you the result.  Thank you.

Hope you enjoy my photo viewer application, Fotag!
Thanks for playing!


