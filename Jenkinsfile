pipeline {
    agent any

    stages {
    /*    stage ('Compile Stage') {

            steps {
                

                  bat"mvn clean compile"

            }
        }

        stage ('Testing Stage') {

            steps {

                    bat"mvn test"

            }
        }*/

stage('build') {
      cmd_exec('echo "Buils starting..."')
      cmd_exec('echo "dir /a /b"')
}

def cmd_exec(command) {
    return bat(returnStdout: true, script: "${command}").trim()
}
        /*stage ('Deployment Stage') {
            steps {

                    bat "mvn deploy"
            }
        }*/
    }
}
