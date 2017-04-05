/**
 * Created by timak31 on 05.04.17.
 */
public class Algoritm {
    private int heightI;
    private int lengthJ;
    private double[][] someMass;

    private double[] ai;    // p(ai)
    private double[] bj;    // p(bj)

    private double[][] pAiSleshBj;  // p(ai/bj)
    private double[][] pBjSleshAi;  // p(bj/ai)

    private double[] hASleshBj;     // H(A/bj)
    private double[] hBSleshAi;     // H(B/ai)

    private double hA;      // H(A)
    private double hB;      // H(B)

    private double hAsleshB;    // H(A/B)
    private double hBsleshA;    // H(B/A)

    public Algoritm(int heightI, int lengthJ, double[][] someMass) {
        this.heightI = heightI;
        this.lengthJ = lengthJ;
        this.someMass = someMass;
    }

    private void getAi() {
        ai = new double[heightI];
        for (int i=0; i<heightI; i++) {
            for (int j=0; j<lengthJ; j++) {
                ai[i] += someMass[i][j];
            }
        }
//
//        for (int i=0; i<heightI; i++) {
//            System.out.println(ai[i]);
//        }
    }

    private void getBj() {
        bj = new double[lengthJ];
        for (int j=0; j<lengthJ; j++) {
            for (int i=0; i<heightI; i++) {
                bj[j] += someMass[i][j];
            }
        }
//
//        for (int j=0; j<lengthJ; j++) {
//            System.out.println(bj[j]);
//        }
    }

    private void getpAiSleshBj() {
        pAiSleshBj = new double[heightI][lengthJ];
        for (int i=0; i<heightI; i++) {
            for (int j=0; j<lengthJ; j++) {
                pAiSleshBj[i][j] = someMass[i][j]/bj[j];
            }
        }
//
//        for (int i=0; i<heightI; i++) {
//            for (int j=0; j<lengthJ; j++) {
//                System.out.print(pAiSleshBj[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    private void getpBjSleshAi() {
        pBjSleshAi = new double[heightI][lengthJ];
        for (int i=0; i<heightI; i++) {
            for (int j=0; j<lengthJ; j++) {
                pBjSleshAi[i][j] = someMass[i][j]/ai[i];
            }
        }
//
//        for (int i=0; i<heightI; i++) {
//            for (int j=0; j<lengthJ; j++) {
//                System.out.print(pBjSleshAi[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    private void gethASleshBj() {
        hASleshBj = new double[lengthJ];
//        System.out.println();
//        System.out.println();
        for (int j=0; j<lengthJ; j++) {
            for (int i=0; i<heightI; i++) {
//                System.out.println("----" + pAiSleshBj[i][j] + " --log-- " + Math.log(pAiSleshBj[i][j])/Math.log(2) + " --- * ---  " + pAiSleshBj[i][j]*Math.log(pAiSleshBj[i][j])/Math.log(2));
                if (pAiSleshBj[i][j] == 0) {
                    hASleshBj[j] += 0;
                } else {
                    hASleshBj[j] += -(pAiSleshBj[i][j] * (Math.log(pAiSleshBj[i][j])/Math.log(2)));
                }
            }
        }
//
//        for (int i=0; i<hASleshBj.length; i++) {
//            System.out.println(hASleshBj[i]);
//        }
    }

    private void gethBSleshAi() {
        hBSleshAi = new double[heightI];
//        System.out.println();
//        System.out.println();
        for (int i=0; i<heightI; i++) {
            for (int j=0; j<lengthJ; j++) {
//                System.out.println("----" + pBjSleshAi[i][j] + " --log-- " + Math.log(pBjSleshAi[i][j])/Math.log(2) + " --- * ---  " + pBjSleshAi[i][j]*Math.log(pBjSleshAi[i][j])/Math.log(2));
                if (pBjSleshAi[i][j] == 0) {
                    hBSleshAi[i] += 0;
                } else {
                    hBSleshAi[i] += -(pBjSleshAi[i][j] * Math.log(pBjSleshAi[i][j])/Math.log(2));
                }
            }
        }
//
//        for (int i=0; i<hBSleshAi.length; i++) {
//            System.out.println(hBSleshAi[i]);
//        }
    }

    private void getHA() {
        for (int i=0; i<heightI; i++) {
            if (ai[i] == 0) {
                hA += 0;
            } else {
                hA += -(ai[i] * Math.log(ai[i])/Math.log(2));
            }
        }
//
//        System.out.println("-------------------------");
//        for (int i=0; i<heightI; i++) {
//            System.out.println(-(ai[i] * Math.log(ai[i])/Math.log(2)));
//        }
//        System.out.println(hA + "\n" + "-------------------------");
    }

    private void getHB() {
        for (int i=0; i<lengthJ; i++) {
            if (bj[i] == 0) {
                hB += 0;
            } else {
                hB += -(bj[i] * Math.log(bj[i])/Math.log(2));
            }
        }
//
//        System.out.println("-------------------------");
//        for (int i=0; i<lengthJ; i++) {
//            System.out.println(-(bj[i] * Math.log(bj[i])/Math.log(2)));
//        }
//        System.out.println(hB + "\n" + "-------------------------");
    }

    private void getHAsleshB() {
        for (int j=0; j<lengthJ; j++) {
            hAsleshB += bj[j] * hASleshBj[j];
        }
        System.out.println("Загальна умовна ентропія джерела А відносно джерела В: H(A/B) = " + hAsleshB);
    }

    private void getHBsleshA() {
        for (int i=0; i<heightI; i++) {
            hBsleshA += ai[i] * hBSleshAi[i];
        }
        System.out.println("Загальна умовна ентропія джерела B відносно джерела A: H(B/A) = " + hBsleshA);
    }

    public void getAllEntropia() {
        getAi();
        getBj();

        getpAiSleshBj();
        getpBjSleshAi();

        gethASleshBj();
        gethBSleshAi();

        getHA();
        getHB();

        getHAsleshB();
        getHBsleshA();

        System.out.println("Ентропія об'єднання цих джерел: H(A, B) = " + (hB+hAsleshB) +
                "\n" + "Кількість інформації, що припадає на одне повідомлення: I(A, B) = " + (hA-hAsleshB));
    }
}
