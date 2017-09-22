#!groovy

node("docker-test") {
    
    sh 'ls -la /opt/jdk8/bin'
    sh '/opt/jdk8/bin/java -version'
    
    withEnv(["JAVA_HOME=/opt/jdk8"]) {

        deleteDir()

        def gradle = "./gradlew"

        stage(name: "Git Checkout"){
            checkout scm
        }


        stage(name: "Clean"){
            sh "${gradle} clean"
        }


        stage(name: "Build"){
            sh "${gradle} build"
        }


        stage(name: "Tests"){
            sh "${gradle} test"
        }


        def version = getVersion()

        stage(name: "Docker Build Imagem API"){
            sh "docker build docker-sample-api -t docker-sample-api:${version}"
            sh "docker build docker-sample-api -t docker-sample-api"
        }


        stage(name: "Docker Push Image API"){
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                sh "docker tag docker-sample-api registry.hub.docker.com/rudolfoborges/docker-sample-api:${version}"
                sh "docker push registry.hub.docker.com/rudolfoborges/docker-sample-api:${version}"

                sh "docker tag docker-sample-api registry.hub.docker.com/rudolfoborges/docker-sample-api"
                sh "docker push registry.hub.docker.com/rudolfoborges/docker-sample-api"
            }
        }

        stage(name: "Docker Build Imagem WEB"){
            sh "docker build docker-sample-web -t docker-sample-web:${version}"
            sh "docker build docker-sample-web -t docker-sample-web"
        }

        stage(name: "Docker Push Image WEB"){
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                sh "docker tag docker-sample-web registry.hub.docker.com/rudolfoborges/docker-sample-web:${version}"
                sh "docker push registry.hub.docker.com/rudolfoborges/docker-sample-web:${version}"

                sh "docker tag docker-sample-web registry.hub.docker.com/rudolfoborges/docker-sample-web"
                sh "docker push registry.hub.docker.com/rudolfoborges/docker-sample-web"
            }
        }


        stage(name: "Docker Deploy"){
            sh "docker stack deploy --compose-file docker-compose.yml docker-sample"
        }
    }

}



def getVersion() {
    def content = readFile(pwd() + "/gradle.properties")
    for (def line in content.split('\n')) {
        if (line =~ /version/) {
            return line.split('=')[1]
        }
    }

    return ''
}
