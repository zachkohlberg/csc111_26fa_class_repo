# Classes

## Instance vs Static

Classes can contain variables and methods (members), each of which can be _static_ or
_instance_ variables/methods.

Static/Class members

- Belongs to the class, not each instance of the class
- Only one copy of a static variable

Non-static/Instance members

- Non-static variables and methods belong to instances of the class
- Each instance gets its own copy of any instance variables
- Instance methods are aware of the instance that called them, not other instances

Remember: class = blueprint/definition, instance = objects created from the class definition
