pipeline {
    agent any

    stages {
       /* stage ('Compile Stage') {

            steps {
                

                   sh "mvn clean compile"

            }
        }*/

        stage ('Testing Stage') {

            steps {

                bat 'mvn --version'
                   // bat "mvn test"

            }
        }


        /*stage ('Deployment Stage') {
            steps {

                    bat "mvn deploy"

            }
        }*/
    }
}
