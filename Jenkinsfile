#!groovy

node("docker") {

    withEnv(["JAVA_HOME=/opt/jdk8"]) {

        deleteDir()

        def gradle = "./gradlew"

        stage(name: "Git Checkout", concurrency: 1)
        checkout scm


        stage(name: "Clean", concurrency: 1)
        sh "${gradle} clean"


        stage(name: "Build", concurrency: 1)
        sh "${gradle} build"


        stage(name: "Tests", concurrency: 1)
        sh "${gradle} test"


        def version = getVersion()


        stage(name: "Docker API Imagem", concurrency: 1)
        sh "docker build -t docker-sample-api docker-sample-api:${version}"
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