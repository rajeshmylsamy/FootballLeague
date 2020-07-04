pipeline {
    agent any

    stages {
        stage ('Build') {

            steps {
                withMaven(maven : 'maven-3') {
                    sh 'mvn clean compile'
                }
            }
        }

        stage ('Test') {

            steps {
                withMaven(maven : 'maven-3') {
                    sh 'mvn test'
                }
            }
        }

        stage ('Install') {

                    steps {
                        withMaven(maven : 'maven-3') {
                            sh 'mvn install'
                        }
                    }
                }

        stage ('Build Docker Image') {

                        steps {
                            withMaven(docker : 'docker') {
                                sh 'docker build -t football-league .'
                              }
                        }
                    }

        stage ('List Docker Image') {

                        steps {
                         withMaven(docker : 'docker') {
                                sh 'docker image ls'
                               }
                        }
                    }

    }
}