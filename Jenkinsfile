pipeline {
    agent any
  docker {
            image 'maven:3.8.1-adoptopenjdk-11' 
            args '-v /root/.m2:/root/.m2' 
        }
    stages {
        stage ('Compile Stage') {

            steps {
                

                 sh "mvn clean compile"

            }
        }

        stage ('Testing Stage') {

            steps {

                    sh "mvn test"

            }
        } 

        /*stage ('Deployment Stage') {
            steps {

                   sh "mvn deploy"
            }
        }*/
    }
}
