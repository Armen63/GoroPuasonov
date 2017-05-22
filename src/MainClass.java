import java.util.LinkedList;
import java.util.Random;

public class MainClass {
    public static void paymanner(int i,int T, LinkedList<Double> kapuxi1, LinkedList<Double> kapuxi2, LinkedList<Double> kapuxi3,
                                 LinkedList<Double> kapuxi4, LinkedList<Double> kapuxi5, LinkedList<Integer> t,
                                 LinkedList<Double> azatmanJamank, LinkedList<Double> tSpasarkum,LinkedList<Double> tSpasum) {
        if (t.get(i) > azatmanJamank.get(i))
            kapuxi1.add(tSpasarkum.get(i));
        else if(t.get(i) > azatmanJamank.get(i-1))
            kapuxi2.add(tSpasarkum.get(i));
        else if(t.get(i) >= azatmanJamank.get(i-2))
            kapuxi3.add(tSpasarkum.get(i-3));
        else if(t.get(i) >= azatmanJamank.get(i-3))
            kapuxi4.add(tSpasarkum.get(i));
        else
            kapuxi5.add(tSpasarkum.get(i));
    }

    public static void main(String[] args) {
        LinkedList<Integer> n = new LinkedList<>();
        LinkedList<Double> r = new LinkedList<>();
        LinkedList<Integer> t = new LinkedList<>();
        LinkedList<Double> t_spasum = new LinkedList<>();
        LinkedList<Integer> tau = new LinkedList<>();
        LinkedList<Double> kapuxi1 = new LinkedList<>();
        LinkedList<Double> kapuxi2 = new LinkedList<>();
        LinkedList<Double> kapuxi3 = new LinkedList<>();
        LinkedList<Double> kapuxi4 = new LinkedList<>();
        LinkedList<Double> kapuxi5 = new LinkedList<>();
        LinkedList<Double> merjvacneriHav = new LinkedList<>(); // en verji keti havna p(m)
        double urishfixSize = 0;
        double fixSize = 0;
        int iteration = 0;
        double pmGcik, sigmaVerjin = 0;
        double nAstxanish = 100.0, epsilyon, zAlfa = 1.96, sumOf1 = 0, sumOf2 = 0, sumOf3 = 0, sumOf4 = 0, sumOf5 = 0, sumOf6 = 0, sumOfSax;
        ;
        LinkedList<Double> saxSpasarkumner = new LinkedList<>();
        int T = 110;
        while (iteration++ < nAstxanish) {
            LinkedList<Double> azatmanJamank = new LinkedList<>();

            System.out.println("---------------------------------------------------------------------- iteration[" + iteration + "]----------------------------------------------------------------------");
            double n0 = 7, lambda = 5, k = 6, m = Math.pow(2, k), h = (int) Math.pow(2, k - 2);
            int a = 3, b = 8, count = 0;
            Integer index, lambdaPuason;
            double sumTau = 0, sumOfT = 0, S, merVekalacT = 110.0;
            Random random = new Random();
            LinkedList<Double> tSpasarkum = new LinkedList<>();
            if (iteration < 2) {
                n.add((int) n0);
                for (int i = 0; i <= T; ++i) {
                    n.add(i + 1, (int) (n.get(i) * lambda % m));
                    System.out.print("n[" + i + "] = " + n.get(i) + "   ");
                    r.add(i, n.get(i + 1) / m);
                    System.out.println("r[" + (i + 1) + "] = " + r.get(i));
                }



                System.out.println("\n• • • • • • • • •  ---------------  • • • • • • • • •\n ");
                //puason
                for (int i = 0; sumTau + sumOfT < merVekalacT; ++i) {
                    index = 0;
                    lambdaPuason = 3;
                    S = 1.0;
                    while (S >= Math.pow(Math.exp(1), -lambdaPuason)) {
                        S *= r.get(random.nextInt(16));
                        index += 1;
                    }
                    tau.add(index);
                    if (i == 0) {
                        t.add(0, tau.get(0));
                        sumOfT = t.get(i);
                    } else {
                        t.add(i, (t.get(i - 1) + tau.get(i)));
                        sumOfT = t.get(i - 1);
                        sumTau = tau.get(i);
                    }
                    t_spasum.add(i, a + (b - a) * r.get(i));

                    if (t.get(i) > merVekalacT)
                        break;
                    System.out.print("tau[" + (i + 1) + "] = " + (index) + "   ");
                    System.out.print("t[" + (i + 1) + "] = " + t.get(i) + "    ");
                    System.out.println("t_spasum[" + (i + 1) + "] = " + t_spasum.get(i));
                }

            }
            fixSize = t.size();
            lambdaPuason = 5;
            double sumOfSpasarkum = 0;
            for (int i = 0; i < t.size(); i++) {
                index = 0;
                S = 1.0;
                while (S >= Math.pow(Math.exp(1), -lambdaPuason)){
                    S *= r.get(random.nextInt(r.size()));
                    index += 1;
                }
                tSpasarkum.add(i, Double.valueOf(index));
                sumOfSpasarkum+=tSpasarkum.get(i);
                System.out.println("t_spasarkum[" + (i + 1) + "]= " + tSpasarkum.get(i));
            }

            urishfixSize = tSpasarkum.size();
            for (int i = 0; i < urishfixSize; i++) {
                if ((t.get(i) + tSpasarkum.get(i)< merVekalacT)) {
                    count += 1;
                    saxSpasarkumner.add(tSpasarkum.get(i));
                    azatmanJamank.add(t.get(i) + tSpasarkum.get(i));
                    /////////////////////////////////////////////////
                }
            }
            for (int i = 0; i < azatmanJamank.size(); i++) {
                if (i == 0)
                    kapuxi1.add(tSpasarkum.get(i));
                else if (i == 1) {
                    if (t.get(i) < azatmanJamank.get(i - 1)) kapuxi2.add(tSpasarkum.get(i));
                    else kapuxi1.add(tSpasarkum.get(i));
                }
                else if (i == 2) {
                    if (t.get(i) > azatmanJamank.get(i - 2)) kapuxi1.add(tSpasarkum.get(i));
                    else if (t.get(i) > azatmanJamank.get(i - 1)) kapuxi2.add(tSpasarkum.get(i));
                    else kapuxi3.add(tSpasarkum.get(i));
                }
                else if(i==3) {
                    if (t.get(i) > azatmanJamank.get(i - 3)) kapuxi1.add(tSpasarkum.get(i));
                    else if (t.get(i) > azatmanJamank.get(i - 2)) kapuxi2.add(tSpasarkum.get(i));
                    else if (t.get(i) > azatmanJamank.get(i - 1))kapuxi3.add(tSpasarkum.get(i));
                    else kapuxi4.add(tSpasarkum.get(i));
                }
                else
                    paymanner(i,T,kapuxi1,kapuxi2,kapuxi3,kapuxi4,kapuxi5,t,azatmanJamank,tSpasarkum,t_spasum);
            }
            System.out.println(azatmanJamank);
            System.out.println("spasarkvele " + count + "  isk spasarkman havanakanutyun@ " + count / fixSize);
            double jlntoz = ((fixSize - count) / fixSize);
            merjvacneriHav.add(jlntoz);
        }
        for (Double aKapuxi1 : kapuxi1) sumOf1 += aKapuxi1;
        for (Double aKapuxi2 : kapuxi2) sumOf2 += aKapuxi2;
        for (Double aKapuxi3 : kapuxi3) sumOf3 += aKapuxi3;
        for (Double aKapuxi4 : kapuxi4) sumOf4 += aKapuxi4;
        for (Double aKapuxi5 : kapuxi5) sumOf5 += aKapuxi5;
        sumOfSax = sumOf1 + sumOf2 + sumOf3 + sumOf4 + sumOf5;


        int kZbaxvac = 3;
        for (int i = 0; i < nAstxanish; i++) {
            kZbaxvac += 3 / nAstxanish;
        }

        sumOfSax = sumOf1 + sumOf2 + sumOf3 + sumOf4 + sumOf5;
        double sumOfPer = 0;
        pmGcik = (1 - (saxSpasarkumner.size() / (fixSize * nAstxanish)));

        for (int i = 0; i < nAstxanish; i++) {
            sumOfPer += Math.pow(merjvacneriHav.get(i) - pmGcik, 2);
        }
        System.out.println("asdasdashgdjasgdjhasdgjhasghdasdhjgas" + sumOfPer);
        sigmaVerjin = Math.sqrt(sumOfPer / (nAstxanish - 1));
        epsilyon = zAlfa * sigmaVerjin / Math.sqrt(nAstxanish);
        System.out.println(sumOfPer);

        System.out.println("\n\n\n1)spasarkman havanakanutyun = " + (saxSpasarkumner.size() / (fixSize * nAstxanish)));
        System.out.println("2)spasarkman toxunakutyun = " + (saxSpasarkumner.size() / (T * nAstxanish)));
        System.out.println("3)merjman havanakanutyun = " + (1 - (saxSpasarkumner.size() / (fixSize * nAstxanish))) + "\n4)");
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    System.out.println("   " + (i + 1) + " kapuxu zbaxvacutyan havanakanutyun@ = " + sumOf1 / (T * nAstxanish * (i + 1)));
                    break;
                case 1:
                    System.out.println("   " + (i + 1) + " kapuxu zbaxvacutyan havanakanutyun@ = " + sumOf2 / (T * nAstxanish * (i+1)));
                    break;
                case 2:
                    System.out.println("   " + (i + 1) + " kapuxu zbaxvacutyan havanakanutyun@ = " + sumOf3 / (T * nAstxanish * (i+1)));
                    break;
                case 3:
                    System.out.println("   " + (i + 1) + " kapuxu zbaxvacutyan havanakanutyun@ = " + sumOf4 / (T * nAstxanish * (i+1)));
                    break;
                case 4:
                    System.out.println("   " + (i + 1) + " kapuxu zbaxvacutyan havanakanutyun@ = " + sumOf5 / (T * nAstxanish * (i+1)));
                    break;
            }
        }
        System.out.println("   amboxj kapuxu zbaxvacutyan havanakanutyun@ = "
                + ((sumOf1 / (T * nAstxanish)) + (sumOf2 / (T * nAstxanish * (2))) + (sumOf3 / (T * nAstxanish * (3)))
                + (sumOf4 / (T * nAstxanish * (4))) + (sumOf5 / (T * nAstxanish * (5)))));
        double zbaxvacutyun1 = sumOf1 / nAstxanish, zbaxvacutyun2 = sumOf2 / nAstxanish, zbaxvacutyun3 = sumOf3 / nAstxanish,
                zbaxvacutyun4 = sumOf4 / nAstxanish, zbaxvacutyun5 = sumOf5 / nAstxanish;
        System.out.println("5)  yuraqanchyur kapuxu zbaxvacutyan mijin jamanak " + zbaxvacutyun1);
        System.out.println("                                                   " + zbaxvacutyun2);
        System.out.println("                                                   " + zbaxvacutyun3);
        System.out.println("                                                   " + zbaxvacutyun4);
        System.out.println("                                                   " + zbaxvacutyun5);
        System.out.println("6)  zbaxvac kapuxineri mijin qanak " + kZbaxvac);
        System.out.println("7)  parapurti havanakanutyun = " + ((T - (sumOf1+sumOf2+sumOf3+sumOf4+sumOf5) / T) / nAstxanish));
        System.out.println("8)  amboxj hamakargi parapurti havanakanutyun@ = " + (1 -((sumOf1 / (T * nAstxanish)) + (sumOf2 / (T * nAstxanish * (2))) + (sumOf3 / (T * nAstxanish * (3)))
                + (sumOf4 / (T * nAstxanish * (4))) + (sumOf5 / (T * nAstxanish * (5))))));
        System.out.println("11) hayti spasakman mijin jamamank = " + (sumOfSax / saxSpasarkumner.size()));
        System.out.println("12) hamakargum hayti gtnvelu mijin jamanak@ = " + ((sumOf1 + sumOf2 + sumOf3 + sumOf4 + sumOf5) / saxSpasarkumner.size()));
        System.out.println("13) " + sigmaVerjin);
        System.out.println("14) " + epsilyon);
        System.out.println(kapuxi1.size() + " " + kapuxi2.size() + " " + kapuxi3.size() + " " + kapuxi4.size() + " " + kapuxi5.size() + " ");
        System.out.println(fixSize);
        System.out.println(sumOf1 + " " + sumOf2 + " " + sumOf3 + " " + sumOf4 + " " + sumOf5);
        System.out.println(kapuxi1);
        System.out.println(sumOf1 + " " + sumOf2 + " " + sumOf3 + " " + sumOf4 +  " " + sumOf5 + " " + sumOf6);
    }
}

