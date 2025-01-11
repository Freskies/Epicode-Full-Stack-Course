# Project Structure

There is a Main class that read input from
the user (it's responsible for the `Scanner`)
and create a `Player` object with the required
number of `Media`.

The number of `Media` objects is determined by a
constant in the `Player` class.

## Media
The `Media` class is an abstract class that
contains the common attributes of all media
objects.

All media objects have a title.

There are two types of media objects:
- `ShowableMedia` can be opened with `.show()` method
- `PlayableMedia`  can be opened with `.play()` method

### ShowableMedia
ShowableMedia class has an abstract method `show()`
that is implemented by the subclasses. `ShowableMedia` also
implements the `Brightness` interface (Everything that can
be shown has a brightness).

### PlayableMedia
PlayableMedia class has an abstract method `play()`
that is implemented by the subclasses. `PlayableMedia`
also implements the `Duration` interface
(Everything that can be played has a duration).

## Volume, Brightness and Duration
Particular type of media objects can have volume,
brightness and duration. Each one is treated as an
Interface that the media object can implement.

_Note that the `Volume` interface is implemented by
the subclasses of `PlayableMedia` and not by the
`PlayableMedia` class itself. This is because,
not in this exercise, but in a real-world scenario,
there could be a playable media that doesn't have
volume (like GIFs for example)._

## Image, Video and Audio
These are the subclasses of `ShowableMedia` and
`PlayableMedia` respectively. They implement the
abstract methods `show()` and `play()`. They also
implement the interfaces `Brightness` and `Volume` based
on their type. 

They are also abstract classes because it seems more
logical to divide them into more specific subclasses
like `PNG` for `Image` and `MP3` for `Audio` etc.