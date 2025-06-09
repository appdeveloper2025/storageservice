pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Clean and build the project
                    sh 'mvn clean package'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    // Run tests
                    sh 'mvn test'
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    // Build the Docker image
                    sh 'docker build -t storageservice .'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Deploy the Docker image (this can be customized based on your deployment strategy)
                    sh 'docker run -d -p 8080:8080 storageservice'
                }
            }
        }
    }
}