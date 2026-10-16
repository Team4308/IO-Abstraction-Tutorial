# IO Abstraction

## Overview

Breaks up subsystems into 4 main components: the interface, the hardware implementation, the simulation implementation, and the actual subsystem.

### Subsystem Structure

```text
Subsystem/
├── Subsystem.java
├── SubsystemIO.java
├── SubsystemIOHardware.java
└── SubsystemIOSim.java
```

The example above does this for a simple motor movement subsystem. To get this code to work, just create a Power loop (a.k.a. testbench) with a TalonFX motor.

### Important

When making your own subsystem, keep the following in mind:

For `@AutoLog`, make sure to add this line to the dependencies section in `build.gradle`:

```gradle
annotationProcessor 'org.littletonrobotics.akit:akit-autolog:26.0.2'
```

Also ensure that you have the AdvantageKit and Phoenix 6 dependencies installed on your machine.

### Running the Simulation

1. Select **Simulate Robot Code**, then choose **Sim GUI**.
2. Make sure your controller is connected and configured correctly in the Sim GUI. (dont forgor to select teleop boi)
3. Open AdvantageScope and select **Connect to Simulator**.
4. Choose **Default: Connect to NT4**.
5. Everything should now be configured! Try moving the joystick and watch the motor respond in AdvantageScope.

If you've made it this far, how about you try making a simple subsystem yourself using the same core principles outlined in this project?

After all, the only way to learn is by doing, not by reading this README...
