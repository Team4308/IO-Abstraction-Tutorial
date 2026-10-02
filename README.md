# IO Abstraction:

## overview:
breaks up subsystems into 4 main components, the interface, the hardware implementation, the simulation implementation, and the actual subsystem.

example code above does it for a simple motor movement subsystem (just create a PowerLoop with a TalonFX motor for this code to work)

important for when you are making your own:
for `@AutoLog`, make sure to add this line to the dependencies section in `build.gradle`:

```gradle
annotationProcessor 'org.littletonrobotics.akit:akit-autolog:26.0.2'
```

Also ensure that you have AdvantageKit & Phoenix 6 dependencies installed on your machine.

If u have made it this far how about you try making a simple subsystem yourself using the same core principles outlines in this project,
after all the only way to learn is by doing, not by reading this README...
