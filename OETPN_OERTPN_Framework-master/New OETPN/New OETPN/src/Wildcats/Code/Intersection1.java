package Wildcats.Code;


import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;
public class Intersection1 {

    public static void main(String[] args) {

        PetriNet pn = new PetriNet();
        pn.PetriNetName = "Intersection";
        pn.NetworkPort = 1080;

        DataString green = new DataString();
        green.Printable = false;
        green.SetName("green");
        green.SetValue("green");
        pn.ConstantPlaceList.add(green);

        DataString full = new DataString();
        full.SetName("full");
        full.SetValue("full");
        pn.ConstantPlaceList.add(full);



        //LANE 1

        DataTransfer OP1 = new DataTransfer();
        OP1.SetName("OP1");
        OP1.Value = new TransferOperation("localhost","1081","in1");
        pn.PlaceList.add(OP1);

        DataCar P_a1 = new DataCar();
        P_a1.SetName("P_a1");
        pn.PlaceList.add(P_a1);

        DataCarQueue P_x1 = new DataCarQueue();
        P_x1.Value.Size =3;
        P_x1.SetName("P_x1");
        pn.PlaceList.add(P_x1);

        DataString P_tl1 = new DataString();
        P_tl1.SetName("P_tl1");
        pn.PlaceList.add(P_tl1);


        DataCar P_b1 = new DataCar();
        P_b1.SetName("P_b1");
        pn.PlaceList.add(P_b1);



        //LANE 2

        DataTransfer OP2 = new DataTransfer();
        OP2.SetName("OP2");
        OP2.Value = new TransferOperation("localhost","1081","in2");
        pn.PlaceList.add(OP2);

        DataCar P_a2 = new DataCar();
        P_a2.SetName("P_a2");
        pn.PlaceList.add(P_a2);

        DataCarQueue P_x2 = new DataCarQueue();
        P_x2.Value.Size =3;
        P_x2.SetName("P_x2");
        pn.PlaceList.add(P_x2);

        DataString P_tl2 = new DataString();
        P_tl2.SetName("P_tl2");
        pn.PlaceList.add(P_tl2);

        DataCar P_b2 = new DataCar();
        P_b2.SetName("P_b2");
        pn.PlaceList.add(P_b2);



        //LANE 3

        DataTransfer OP3 = new DataTransfer();
        OP3.SetName("OP3");
        OP3.Value = new TransferOperation("localhost","1081","in3");
        pn.PlaceList.add(OP3);

        DataCar P_a3 = new DataCar();
        P_a3.SetName("P_a3");
        pn.PlaceList.add(P_a3);

        DataCarQueue P_x3 = new DataCarQueue();
        P_x3.Value.Size =3;
        P_x3.SetName("P_x3");
        pn.PlaceList.add(P_x3);

        DataString P_tl3 = new DataString();
        P_tl3.SetName("P_tl3");
        pn.PlaceList.add(P_tl3);

        DataCar P_b3 = new DataCar();
        P_b3.SetName("P_b3");
        pn.PlaceList.add(P_b3);


        //LANE 4

        DataTransfer OP4 = new DataTransfer();
        OP4.SetName("OP4");
        OP4.Value = new TransferOperation("localhost","1081","in4");
        pn.PlaceList.add(OP4);

        DataCar P_a4 = new DataCar();
        P_a4.SetName("P_a4");
        pn.PlaceList.add(P_a4);

        DataCarQueue P_x4 = new DataCarQueue();
        P_x4.Value.Size =3;
        P_x4.SetName("P_x4");
        pn.PlaceList.add(P_x4);

        DataCar P_b4 = new DataCar();
        P_b4.SetName("P_b4");
        pn.PlaceList.add(P_b4);

        DataString P_tl4 = new DataString();
        P_tl4.SetName("P_tl4");
        pn.PlaceList.add(P_tl4);


        // EXIT LANE 1

        DataCarQueue P_o1 = new DataCarQueue();
        P_o1.Value.Size = 3;
        P_o1.SetName("P_o1");
        pn.PlaceList.add(P_o1);

        DataCar P_o2 = new DataCar();
        P_o2.SetName("P_o2");
        pn.PlaceList.add(P_o2);

        // EXIT LANE 2

        DataCarQueue P_o3 = new DataCarQueue();
        P_o3.Value.Size = 3;
        P_o3.SetName("P_o3");
        pn.PlaceList.add(P_o3);

        DataCar P_o4 = new DataCar();
        P_o4.SetName("P_o4");
        pn.PlaceList.add(P_o4);

        // EXIT LANE 3

        DataCarQueue P_o5 = new DataCarQueue();
        P_o5.Value.Size = 3;
        P_o5.SetName("P_o5");
        pn.PlaceList.add(P_o5);

        DataCar P_o6 = new DataCar();
        P_o6.SetName("P_o6");
        pn.PlaceList.add(P_o6);

        // EXIT LANE 4

        DataCarQueue P_o7 = new DataCarQueue();
        P_o7.Value.Size = 3;
        P_o7.SetName("P_o7");
        pn.PlaceList.add(P_o7);

        DataCar P_o8 = new DataCar();
        P_o8.SetName("P_o8");
        pn.PlaceList.add(P_o8);


        // Intersection Lane

        DataCarQueue P_I1 = new DataCarQueue();
        P_I1.Value.Size = 3;
        P_I1.SetName("P_I1");
        pn.PlaceList.add(P_I1);

        // LINK LANE BETWEEN INTERSECTIONS
        DataTransfer P_street1 = new DataTransfer();
        P_street1.SetName("P_street1");
        P_street1.Value = new TransferOperation("localhost","1082","P_a8");
        pn.PlaceList.add(P_street1);


        // ENTERING LANES
        // TRANSITION 1 - t_u1

        PetriTransition t_u1 = new PetriTransition(pn);
        t_u1.TransitionName = "t_u1";
        t_u1.InputPlaceName.add("P_a1");
        t_u1.InputPlaceName.add("P_x1");

        Condition T1Ct1 = new Condition(t_u1,"P_a1",TransitionCondition.NotNull);
        Condition T1Ct2 = new Condition(t_u1,"P_x1",TransitionCondition.CanAddCars);
        T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

        Condition T1Ct3 = new Condition(t_u1, "P_a1", TransitionCondition.NotNull);
        Condition T1Ct4 = new Condition(t_u1, "P_x1", TransitionCondition.CanNotAddCars);
        T1Ct3.SetNextCondition(LogicConnector.AND, T1Ct4);

        GuardMapping grdT1 = new GuardMapping();
        grdT1.condition= T1Ct1;
        grdT1.Activations.add(new Activation(t_u1, "P_a1", TransitionOperation.AddElement, "P_x1"));
        t_u1.GuardMappingList.add(grdT1);

        GuardMapping grd2T1 = new GuardMapping();
        grd2T1.condition= T1Ct3;
        grd2T1.Activations.add(new Activation(t_u1, "full", TransitionOperation.SendOverNetwork, "OP1"));
        grd2T1.Activations.add(new Activation(t_u1, "P_a1", TransitionOperation.Move, "P_a1"));
        t_u1.GuardMappingList.add(grd2T1);

        t_u1.Delay = 0;
        pn.Transitions.add(t_u1);


        // TRANSITION 2 - t_u2

        PetriTransition t_u2 = new PetriTransition(pn);
        t_u2.TransitionName = "t_u2";
        t_u2.InputPlaceName.add("P_x1");
        t_u2.InputPlaceName.add("P_tl1");


        Condition T2Ct1 = new Condition(t_u2, "P_tl1", TransitionCondition.Equal,"green");
        Condition T2Ct2 = new Condition(t_u2, "P_x1", TransitionCondition.HaveCar);
        T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

        GuardMapping grdT2 = new GuardMapping();
        grdT2.condition = T2Ct1;
        grdT2.Activations.add(new Activation(t_u2, "P_x1", TransitionOperation.PopElementWithoutTarget, "P_b1"));
        grdT2.Activations.add(new Activation(t_u2, "P_tl1", TransitionOperation.Move, "P_tl1"));
        t_u2.GuardMappingList.add(grdT2);

        t_u2.Delay = 0;
        pn.Transitions.add(t_u2);


        // TRANSITION 3 - T_u3

        PetriTransition t_u3 = new PetriTransition(pn);
        t_u3.TransitionName = "t_u3";
        t_u3.InputPlaceName.add("P_a2");
        t_u3.InputPlaceName.add("P_x2");

        Condition T3Ct1 = new Condition(t_u3,"P_a2",TransitionCondition.NotNull);
        Condition T3Ct2 = new Condition(t_u3,"P_x2",TransitionCondition.CanAddCars);
        T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

        Condition T3Ct3 = new Condition(t_u3, "P_a2", TransitionCondition.NotNull);
        Condition T3Ct4 = new Condition(t_u3, "P_x2", TransitionCondition.CanNotAddCars);
        T3Ct3.SetNextCondition(LogicConnector.AND, T3Ct4);

        GuardMapping grdT3 = new GuardMapping();
        grdT3.condition= T3Ct1;
        grdT3.Activations.add(new Activation(t_u3, "P_a2", TransitionOperation.AddElement, "P_x2"));
        t_u3.GuardMappingList.add(grdT3);

        GuardMapping grd2T3 = new GuardMapping();
        grd2T3.condition= T3Ct3;
        grd2T3.Activations.add(new Activation(t_u3, "full", TransitionOperation.SendOverNetwork, "OP2"));
        grd2T3.Activations.add(new Activation(t_u3, "P_a2", TransitionOperation.Move, "P_a2"));
        t_u3.GuardMappingList.add(grd2T3);

        t_u3.Delay = 0;
        pn.Transitions.add(t_u3);


        // TRANSITION4 - T_u4

        PetriTransition t_u4 = new PetriTransition(pn);
        t_u4.TransitionName = "t_u4";
        t_u4.InputPlaceName.add("P_x2");
        t_u4.InputPlaceName.add("P_tl2");


        Condition T4Ct1 = new Condition(t_u4, "P_tl2", TransitionCondition.Equal,"green");
        Condition T4Ct2 = new Condition(t_u4, "P_x2", TransitionCondition.HaveCar);
        T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

        GuardMapping grdT4 = new GuardMapping();
        grdT4.condition = T4Ct1;
        grdT4.Activations.add(new Activation(t_u4, "P_x2", TransitionOperation.PopElementWithoutTarget, "P_b2"));
        grdT4.Activations.add(new Activation(t_u4, "P_tl2", TransitionOperation.Move, "P_tl2"));
        t_u4.GuardMappingList.add(grdT4);

        t_u4.Delay = 0;
        pn.Transitions.add(t_u4);


        // TRANSITION5 - T_u5

        PetriTransition t_u5 = new PetriTransition(pn);
        t_u5.TransitionName = "t_u5";
        t_u5.InputPlaceName.add("P_a3");
        t_u5.InputPlaceName.add("P_x3");

        Condition T5Ct1 = new Condition(t_u5,"P_a3",TransitionCondition.NotNull);
        Condition T5Ct2 = new Condition(t_u5,"P_x3",TransitionCondition.CanAddCars);
        T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);

        Condition T5Ct3 = new Condition(t_u5, "P_a3", TransitionCondition.NotNull);
        Condition T5Ct4 = new Condition(t_u5, "P_x3", TransitionCondition.CanNotAddCars);
        T5Ct3.SetNextCondition(LogicConnector.AND, T5Ct4);

        GuardMapping grdT5 = new GuardMapping();
        grdT5.condition= T5Ct1;
        grdT5.Activations.add(new Activation(t_u5, "P_a3", TransitionOperation.AddElement, "P_x3"));
        t_u5.GuardMappingList.add(grdT5);

        GuardMapping grd2T5 = new GuardMapping();
        grd2T5.condition= T5Ct3;
        grd2T5.Activations.add(new Activation(t_u5, "full", TransitionOperation.SendOverNetwork, "OP3"));
        grd2T5.Activations.add(new Activation(t_u5, "P_a3", TransitionOperation.Move, "P_a3"));
        t_u5.GuardMappingList.add(grd2T5);

        t_u5.Delay = 0;
        pn.Transitions.add(t_u5);


        // TRANSITION6 - T_u6

        PetriTransition t_u6 = new PetriTransition(pn);
        t_u6.TransitionName = "t_u6";
        t_u6.InputPlaceName.add("P_x3");
        t_u6.InputPlaceName.add("P_tl3");


        Condition T6Ct1 = new Condition(t_u6, "P_tl3", TransitionCondition.Equal,"green");
        Condition T6Ct2 = new Condition(t_u6, "P_x3", TransitionCondition.HaveCar);
        T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

        GuardMapping grdT6 = new GuardMapping();
        grdT6.condition = T6Ct1;
        grdT6.Activations.add(new Activation(t_u6, "P_x3", TransitionOperation.PopElementWithoutTarget, "P_b3"));
        grdT6.Activations.add(new Activation(t_u6, "P_tl3", TransitionOperation.Move, "P_tl3"));
        t_u6.GuardMappingList.add(grdT6);

        t_u6.Delay = 0;
        pn.Transitions.add(t_u6);


        // TRANSITION7 - t_u7

        PetriTransition t_u7 = new PetriTransition(pn);
        t_u7.TransitionName = "t_u7";
        t_u7.InputPlaceName.add("P_a4");
        t_u7.InputPlaceName.add("P_x4");

        Condition T7Ct1 = new Condition(t_u7,"P_a4",TransitionCondition.NotNull);
        Condition T7Ct2 = new Condition(t_u7,"P_x4",TransitionCondition.CanAddCars);
        T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);

        Condition T7Ct3 = new Condition(t_u7, "P_a4", TransitionCondition.NotNull);
        Condition T7Ct4 = new Condition(t_u7, "P_x4", TransitionCondition.CanNotAddCars);
        T7Ct3.SetNextCondition(LogicConnector.AND, T7Ct4);

        GuardMapping grdT7 = new GuardMapping();
        grdT7.condition= T7Ct1;
        grdT7.Activations.add(new Activation(t_u7, "P_a4", TransitionOperation.AddElement, "P_x4"));
        t_u7.GuardMappingList.add(grdT7);

        GuardMapping grd2T7 = new GuardMapping();
        grd2T7.condition= T7Ct3;
        grd2T7.Activations.add(new Activation(t_u7, "full", TransitionOperation.SendOverNetwork, "OP4"));
        grd2T7.Activations.add(new Activation(t_u7, "P_a4", TransitionOperation.Move, "P_a4"));
        t_u7.GuardMappingList.add(grd2T7);

        t_u7.Delay = 0;
        pn.Transitions.add(t_u7);


        // TRANSITION8 - t_u8

        PetriTransition t_u8 = new PetriTransition(pn);
        t_u8.TransitionName = "t_u8";
        t_u8.InputPlaceName.add("P_x4");
        t_u8.InputPlaceName.add("P_tl4");


        Condition T8Ct1 = new Condition(t_u8, "P_tl4", TransitionCondition.Equal,"green");
        Condition T8Ct2 = new Condition(t_u8, "P_x4", TransitionCondition.HaveCar);
        T8Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

        GuardMapping grdT8 = new GuardMapping();
        grdT8.condition = T8Ct1;
        grdT8.Activations.add(new Activation(t_u8, "P_x4", TransitionOperation.PopElementWithoutTarget, "P_b4"));
        grdT8.Activations.add(new Activation(t_u8, "P_tl4", TransitionOperation.Move, "P_tl4"));
        t_u8.GuardMappingList.add(grdT8);

        t_u8.Delay = 0;
        pn.Transitions.add(t_u8);



        // EXITING LANES
        // TRANSITION 9 - t_e2
        PetriTransition t_e2 = new PetriTransition(pn);
        t_e2.TransitionName = "t_e2";
        t_e2.InputPlaceName.add("P_o1");

        Condition T9Ct1 = new Condition(t_e2,"P_o1",TransitionCondition.HaveCar);

        GuardMapping grdT9 = new GuardMapping();
        grdT9.condition = T9Ct1;
        grdT9.Activations.add(new Activation(t_e2, "P_o1", TransitionOperation.PopElementWithoutTarget, "P_o2"));
        t_e2.GuardMappingList.add(grdT9);

        t_e2.Delay = 0;
        pn.Transitions.add(t_e2);

        // TRANSITION 10 - t_e4
        PetriTransition t_e4 = new PetriTransition(pn);
        t_e4.TransitionName = "t_e4";
        t_e4.InputPlaceName.add("P_o3");

        Condition T10Ct1 = new Condition(t_e4,"P_o3",TransitionCondition.HaveCar);

        GuardMapping grdT10 = new GuardMapping();
        grdT10.condition = T10Ct1;
        grdT10.Activations.add(new Activation(t_e4, "P_o3", TransitionOperation.PopElementWithoutTarget, "P_o4"));
        t_e4.GuardMappingList.add(grdT10);

        t_e4.Delay = 0;
        pn.Transitions.add(t_e4);

        // TRANSITION 11 - t_e6

        PetriTransition t_e6 = new PetriTransition(pn);
        t_e6.TransitionName = "t_e6";
        t_e6.InputPlaceName.add("P_o5");

        Condition T11Ct1 = new Condition(t_e6,"P_o5",TransitionCondition.HaveCar);

        GuardMapping grdT11 = new GuardMapping();
        grdT11.condition = T11Ct1;
        grdT11.Activations.add(new Activation(t_e6, "P_o5", TransitionOperation.PopElementWithoutTarget, "P_o6"));
        t_e6.GuardMappingList.add(grdT11);

        t_e6.Delay = 0;
        pn.Transitions.add(t_e6);

        // TRANSITION 12 - t_e8
        PetriTransition t_e8 = new PetriTransition(pn);
        t_e8.TransitionName = "t_e8";
        t_e8.InputPlaceName.add("P_o7");

        Condition T12Ct1 = new Condition(t_e8,"P_o7",TransitionCondition.HaveCar);

        GuardMapping grdT12 = new GuardMapping();
        grdT12.condition = T12Ct1;
        grdT12.Activations.add(new Activation(t_e8, "P_o7", TransitionOperation.PopElementWithoutTarget, "P_o8"));
        t_e8.GuardMappingList.add(grdT12);

        t_e8.Delay = 0;
        pn.Transitions.add(t_e8);


        // INTERSECTION ENTRANCE

        // TRANSITION 14 - t_i1
        PetriTransition t_i1 = new PetriTransition(pn);
        t_i1.TransitionName = "t_i1";
        t_i1.InputPlaceName.add("P_I1");
        t_i1.InputPlaceName.add("P_b1");

        Condition T14Ct1 = new Condition(t_i1,"P_b1",TransitionCondition.NotNull);
        Condition T14Ct2 = new Condition(t_i1,"P_I1",TransitionCondition.CanAddCars);
        T14Ct1.SetNextCondition(LogicConnector.AND, T14Ct2);

        GuardMapping grdT14 = new GuardMapping();
        grdT14.condition = T14Ct1;
        grdT14.Activations.add(new Activation(t_i1,"P_b1",TransitionOperation.AddElement,"P_I1"));
        t_i1.GuardMappingList.add(grdT14);

        t_i1.Delay=0;
        pn.Transitions.add(t_i1);

        // TRANSITION 15 - t_i2

        PetriTransition t_i2 = new PetriTransition(pn);
        t_i2.TransitionName = "t_i2";
        t_i2.InputPlaceName.add("P_I1");
        t_i2.InputPlaceName.add("P_b2");

        Condition T15Ct1 = new Condition(t_i2,"P_b2",TransitionCondition.NotNull);
        Condition T15Ct2 = new Condition(t_i2,"P_I1",TransitionCondition.CanAddCars);
        T15Ct1.SetNextCondition(LogicConnector.AND, T15Ct2);

        GuardMapping grdT15 = new GuardMapping();
        grdT15.condition = T15Ct1;
        grdT15.Activations.add(new Activation(t_i2,"P_b2",TransitionOperation.AddElement,"P_I1"));
        t_i2.GuardMappingList.add(grdT15);

        t_i2.Delay=0;
        pn.Transitions.add(t_i2);

        // TRANSITION 16 - t_i3
        PetriTransition t_i3 = new PetriTransition(pn);
        t_i3.TransitionName = "t_i3";
        t_i3.InputPlaceName.add("P_I1");
        t_i3.InputPlaceName.add("P_b3");

        Condition T16Ct1 = new Condition(t_i3,"P_b3",TransitionCondition.NotNull);
        Condition T16Ct2 = new Condition(t_i3,"P_I1",TransitionCondition.CanAddCars);
        T16Ct1.SetNextCondition(LogicConnector.AND, T16Ct2);

        GuardMapping grdT16 = new GuardMapping();
        grdT16.condition = T16Ct1;
        grdT16.Activations.add(new Activation(t_i3,"P_b3",TransitionOperation.AddElement,"P_I1"));
        t_i3.GuardMappingList.add(grdT16);

        t_i3.Delay=0;
        pn.Transitions.add(t_i3);

        // TRANSITION 17 - t_i4
        PetriTransition t_i4 = new PetriTransition(pn);
        t_i4.TransitionName = "t_i4";
        t_i4.InputPlaceName.add("P_I1");
        t_i4.InputPlaceName.add("p_b4");

        Condition T17Ct1 = new Condition(t_i4,"p_b4",TransitionCondition.NotNull);
        Condition T17Ct2 = new Condition(t_i4,"P_I1",TransitionCondition.CanAddCars);
        T17Ct1.SetNextCondition(LogicConnector.AND, T17Ct2);

        GuardMapping grdT17 = new GuardMapping();
        grdT17.condition = T17Ct1;
        grdT17.Activations.add(new Activation(t_i4,"P_b4",TransitionOperation.AddElement,"P_I1"));
        t_i4.GuardMappingList.add(grdT17);

        t_i4.Delay=0;
        pn.Transitions.add(t_i4);

        // TRANSITION 18 - t_e1

        PetriTransition t_e1=new PetriTransition(pn);
        t_e1.TransitionName="t_e1";
        t_e1.InputPlaceName.add("P_o1");
        t_e1.InputPlaceName.add("P_I1");

        Condition T18Ct1= new Condition(t_e1,"P_o1",TransitionCondition.CanAddCars);
        Condition T18Ct2= new Condition(t_e1, "P_I1", TransitionCondition.HaveCarForMe);
        T18Ct1.SetNextCondition(LogicConnector.AND,T18Ct2);

        GuardMapping grdT18= new GuardMapping();
        grdT18.condition=T18Ct1;
        grdT18.Activations.add(new Activation(t_e1, "P_I1", TransitionOperation.PopElementWithTargetToQueue, "P_o1"));
        t_e1.GuardMappingList.add(grdT18);

        t_e1.Delay = 0;
        pn.Transitions.add(t_e1);

        // TRANSITION 19 - t_e3
        PetriTransition t_e3=new PetriTransition(pn);
        t_e3.TransitionName="t_e3";
        t_e3.InputPlaceName.add("P_o3");
        t_e3.InputPlaceName.add("P_I1");

        Condition T19Ct1= new Condition(t_e3,"P_o3",TransitionCondition.CanAddCars);
        Condition T19Ct2= new Condition(t_e3, "P_I1", TransitionCondition.HaveCarForMe);
        T19Ct1.SetNextCondition(LogicConnector.AND,T19Ct2);

        GuardMapping grdT19= new GuardMapping();
        grdT19.condition=T19Ct1;
        grdT19.Activations.add(new Activation(t_e3, "P_I1", TransitionOperation.PopElementWithTargetToQueue, "P_o3"));
        t_e3.GuardMappingList.add(grdT19);

        t_e3.Delay = 0;
        pn.Transitions.add(t_e3);

        // TRANSITION 20 - t_e5
        PetriTransition t_e5=new PetriTransition(pn);
        t_e5.TransitionName="t_e5";
        t_e5.InputPlaceName.add("P_o5");
        t_e5.InputPlaceName.add("P_I1");

        Condition T20Ct1= new Condition(t_e5,"P_o5",TransitionCondition.CanAddCars);
        Condition T20Ct2= new Condition(t_e5, "P_I1", TransitionCondition.HaveCarForMe);
        T20Ct1.SetNextCondition(LogicConnector.AND,T20Ct2);

        GuardMapping grdT20= new GuardMapping();
        grdT20.condition=T20Ct1;
        grdT20.Activations.add(new Activation(t_e5, "P_I1", TransitionOperation.PopElementWithTargetToQueue, "P_o5"));
        t_e5.GuardMappingList.add(grdT20);

        t_e5.Delay = 0;
        pn.Transitions.add(t_e5);

        // TRANSITION 21 - t_e7
        PetriTransition t_e7=new PetriTransition(pn);
        t_e7.TransitionName="t_e7";
        t_e7.InputPlaceName.add("P_o7");
        t_e7.InputPlaceName.add("P_I1");

        Condition T21Ct1= new Condition(t_e7,"P_o7",TransitionCondition.CanAddCars);
        Condition T21Ct2= new Condition(t_e7, "P_I1", TransitionCondition.HaveCarForMe);
        T21Ct1.SetNextCondition(LogicConnector.AND,T21Ct2);

        GuardMapping grdT21= new GuardMapping();
        grdT21.condition=T21Ct1;
        grdT21.Activations.add(new Activation(t_e7, "P_I1", TransitionOperation.PopElementWithTargetToQueue, "P_o7"));
        t_e7.GuardMappingList.add(grdT21);

        t_e7.Delay = 0;
        pn.Transitions.add(t_e7);

        // TRANSITION 22 - t_street1
        PetriTransition t_street1=new PetriTransition(pn);
        t_street1.TransitionName="t_street1";
        t_street1.InputPlaceName.add("P_o4");


        Condition T22Ct1= new Condition(t_street1,"P_o4",TransitionCondition.NotNull);

        GuardMapping grdT22= new GuardMapping();
        grdT22.condition=T22Ct1;
        grdT22.Activations.add(new Activation(t_street1, "P_o4", TransitionOperation.SendOverNetwork, "P_street1"));
        t_street1.GuardMappingList.add(grdT22);

        t_street1.Delay = 0;
        pn.Transitions.add(t_street1);



        // Petri Start
        System.out.println("Intersection started");
        pn.Delay = 2000;


        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }

}
