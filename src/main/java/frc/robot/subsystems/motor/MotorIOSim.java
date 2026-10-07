package frc.robot.subsystems.motor;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class MotorIOSim implements MotorIO {

    // Simulating 1 Kraken X60 motor with 1:1 gear ratio and standard inertia
    private final DCMotorSim sim =
        new DCMotorSim(
            LinearSystemId.createDCMotorSystem(DCMotor.getKrakenX60(1), 0.001, 1.0),
            DCMotor.getKrakenX60(1)
        );

    private double appliedVolts = 0.0;

    @Override
    public void updateInputs(MotorIOInputs inputs) {
        sim.update(0.02);

        inputs.position = sim.getAngularPositionRotations();
        inputs.velocity = Units.radiansToRotations(sim.getAngularVelocityRadPerSec());
        inputs.appliedVolts = appliedVolts;
        inputs.currentAmps = sim.getCurrentDrawAmps();
    }

    @Override
    public void runVolts(double volts) {
        appliedVolts = MathUtil.clamp(volts, -12.0, 12.0);
        sim.setInputVoltage(appliedVolts);
    }

    @Override
    public void estop() {
        runVolts(0.0);
    }
}