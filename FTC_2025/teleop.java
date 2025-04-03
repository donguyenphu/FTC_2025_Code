package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Test23 (Blocks to Java)")
public class Test23 extends LinearOpMode {

  private Servo servoIntake;
  private Servo servoIntakeLiftLeft;
  private Servo servoIntakeLiftRight;
  private Servo servoOuttake;
  private DcMotor motorControlDriveBaseRight;
  private DcMotor motorControlDriveBaseLeft;
  private DcMotor motorExpansionSingle;
  private DcMotor motorControlLeft;
  private DcMotor motorControlRight;
  private Servo servoOuttakeLift;

  /**
   * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
   * Comment Blocks show where to place Initialization code (runs once, after touching the
   * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
   * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
   * Stopped).
   */
  @Override
  public void runOpMode() {
    double Power_gain;
    double arm_power_gain;
    double intake_arm_gain;
    int arm_position_2;
    int servoLiftIntakeToggle;
    int Servo_position;
    int Servo_position_2;
    int Servo_position_3;
    int Servo_position_4;
    boolean Last_value_of_A;
    boolean Last_value_of_X;
    boolean Last_value_of_LB;
    boolean Last_value_of_RB;

    servoIntake = hardwareMap.get(Servo.class, "servoIntake");
    servoIntakeLiftLeft = hardwareMap.get(Servo.class, "servoIntakeLiftLeft");
    servoIntakeLiftRight = hardwareMap.get(Servo.class, "servoIntakeLiftRight");
    servoOuttake = hardwareMap.get(Servo.class, "servoOuttake");
    motorControlDriveBaseRight = hardwareMap.get(DcMotor.class, "motorControlDriveBaseRight");
    motorControlDriveBaseLeft = hardwareMap.get(DcMotor.class, "motorControlDriveBaseLeft");
    motorExpansionSingle = hardwareMap.get(DcMotor.class, "motorExpansionSingle");
    motorControlLeft = hardwareMap.get(DcMotor.class, "motorControlLeft");
    motorControlRight = hardwareMap.get(DcMotor.class, "motorControlRight");
    servoOuttakeLift = hardwareMap.get(Servo.class, "servoOuttakeLift");

    // SET SCALE RANGE FOR SERVO
    servoIntake.scaleRange(0, 0.25);
    servoIntakeLiftLeft.scaleRange(0, 0.7);
    servoIntakeLiftRight.setDirection(Servo.Direction.FORWARD);
    servoIntakeLiftRight.scaleRange(0.7, 1.25);
    servoOuttake.scaleRange(0.5, 1);
    servoOuttake.setDirection(Servo.Direction.FORWARD);
    // PROPERTIES FOR DRIVE BASE MOTORS
    motorControlDriveBaseRight.setPower(0);
    motorControlDriveBaseLeft.setPower(0);
    motorControlDriveBaseLeft.setDirection(DcMotor.Direction.REVERSE);
    motorControlDriveBaseRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    motorControlDriveBaseLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    motorExpansionSingle.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    motorControlLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    motorControlRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    Power_gain = 1.2;
    arm_power_gain = 1.2;
    intake_arm_gain = 1.2;
    arm_position_2 = 0;
    servoLiftIntakeToggle = 0;
    Servo_position = 0;
    Servo_position_2 = 0;
    Servo_position_3 = 0;
    Servo_position_4 = 0;
    servoIntake.setPosition(Servo_position);
    servoOuttake.setPosition(Servo_position_3);
    servoIntakeLiftLeft.setPosition(0);
    servoIntakeLiftRight.setPosition(0.5);
    Last_value_of_A = false;
    Last_value_of_X = false;
    Last_value_of_LB = false;
    Last_value_of_RB = false;
    waitForStart();
    // Put run blocks here.
    while (opModeIsActive()) {
      servoOuttakeLift.setPosition(gamepad1.right_stick_y * 1);
      // INTAKE MOTOR
      motorExpansionSingle.setPower(gamepad1.right_trigger * arm_power_gain);
      motorExpansionSingle.setPower(gamepad1.left_trigger * -1 * arm_power_gain);
      // OUTTAKE MOTOR
      motorControlLeft.setPower(gamepad1.right_stick_y * 1);
      motorControlRight.setPower(gamepad1.right_stick_y * 1);
      // DRIVE BASE MOTOR
      motorControlDriveBaseRight.setPower((gamepad1.left_stick_y + gamepad1.left_stick_x) * Power_gain);
      motorControlDriveBaseLeft.setPower((gamepad1.left_stick_y - gamepad1.left_stick_x) * Power_gain);
      // SERVO INTAKE ARM
      if (Last_value_of_RB == false && gamepad1.right_bumper == true) {
        if (Servo_position == 0) {
          Servo_position = 1;
        } else {
          Servo_position = 0;
        }
      }
      Last_value_of_RB = gamepad1.right_bumper;
      servoIntake.setPosition(Servo_position);
      // SERVO HIGH ARM
      if (Last_value_of_LB == false && gamepad1.left_bumper == true) {
        if (Servo_position_3 == 0) {
          Servo_position_3 = 1;
        } else {
          Servo_position_3 = 0;
        }
      }
      Last_value_of_LB = gamepad1.left_bumper;
      servoOuttake.setPosition(Servo_position_3);
      // SERVO LIFT INTAKE ARM
      if (Last_value_of_A == false && gamepad1.a == true) {
        if (Servo_position_4 == 0) {
          Servo_position_4 = 1;
        } else {
          Servo_position_4 = 0;
        }
      }
      Last_value_of_A = gamepad1.a;
      servoIntakeLiftRight.setPosition(Servo_position_4);
    }
  }
}