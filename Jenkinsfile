pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
    }

    stages {
        stage('CleanUp') {
            steps {
                cleanWs()
            }
        }

        stage('Checkout') {
            steps {
                git 'git@github.com:AnubhaJoshiSharma/AllureSeleniumJenkins.git'
            }
        }

        stage('Build') {
            steps {
                build job: 'AllureMavenJenkinsGithub', parameters: [string(name: 'runnerFILE', value: 'MasterSuiteFile.xml')]
            }
        }
    }

    post {
        success {
            allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
        }
    }
}
