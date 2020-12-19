pipeline {
    agent any

    stages {
        stage('Checkout'){
            steps {
                git branch: 'main', url: 'https://github.com/ankh361/jgsu-spring-petclinic.git'
            }
        }
        stage('Build') {
            steps {
                bat "mvnw.cmd clean compile"   
            }

            post {
                 
                 always {
                     junit '**target/surefire-reports/TEST-*.xml'
                     archiveArtifacts 'target/*.jar'
                 }
             }
        }
    }
}