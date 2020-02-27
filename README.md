# SYT GEK103x Datamanagement "Distributed Data Structures"

## Einführung

Komplexe und aufteilbare Tasks müssen mit Parametern ausgestattet  werden und von entsprechenden Koordinatoren gestartet bzw. die  erhaltenen Daten wieder zusammengefasst werden. Diese Art von verteilter Programmierung findet in vielen Anwendungsgebieten rege Verwendung (AI  Daten Analyse, Lastverteilung, etc.). Hierbei kommt das Prinzip des  Master/Worker Patterns (Master-Slave oder Map-Reduce Pattern) zum  Einsatz.

## Ziele

Finden Sie eine Lösung, die in einer Cloud-Umgebung ausrollbar  (deployable) ist. Die einzelnen Worker sollen unabhängig voneinander  bestehen können und mit Input-Parametern gestartet werden. Die  berechneten Daten müssen an den Master bzw. als Zwischenberechnung an  andere Worker weitergegeben werden können. Die einzelnen Worker sollen  unabhängig von der Umgebung gestartet werden können (unterschiedliche  Servereinheiten).

## Voraussetzungen

- Grundverständnis von Python oder Java
- Lesen und Umsetzen von APIs
- Fähigkeit komplexe Programmier-Aufgaben zu implementieren und zu verteilen

## Detailierte Ausgabenbeschreibung

Recherchieren Sie mögliche Werkzeuge für das "distributed Computing". Vergleichen Sie mögliche Produkte in Bezug auf folgende Parameter:

- Architektur
- einsetzbare Programmiersprachen
- Datenverteilung und gemeinsamer Speicher
- Performance bei Main-Focus
- Notifikation von Master oder anderen Slaves

Nehmen Sie eine komplexe Aufgabenstellung/Berechnung und zeigen Sie  anhand von einer Beispiel-Konfiguration, wie die Verteilung der  Berechnung und anschließende Zusammenführung der Daten funktioniert. Bei ähnlichen oder gleichen Berechnungen wäre ein direkter Vergleich  (Benchmark) der gewählten Tools/Technologien von Vorteil.

## Bewertung

Gruppengrösse: 1 Person

### Grundlegende Anforderungen **überwiegend erfüllt**

- Vergleich von Technologien

### Grundlegende Anforderungen **zur Gänze erfüllt**

- Einsatz eines Beispiels zur Veranschaulichung der Funktionsweise

### Erweiterte Anforderungen **überwiegend erfüllt**

- Einsatz einer zweiten Implementierung

### Erweiterte Anforderungen **zur Gänze erfüllt**

- Benchmark von zwei verschiedenen Technologien

## Quellen

- "A reactive Java framework for building fault-tolerant distributed systems" Atomix [github](https://github.com/atomix/atomix)
- "What is Atomix?" [atomix.io](https://atomix.io/docs/latest/user-manual/introduction/what-is-atomix/)
- "Introduction to Atomix" [baeldung](https://www.baeldung.com/atomix)
- "Primitive Protocols" [atomix.io](https://atomix.io/docs/latest/user-manual/primitives/primitive-protocols/)
- "The Raft Consensus Algorithm" [online](https://raft.github.io/)
- "In Search of an Understandable Consensus Algorithm" Raft-Paper; Stanford University; [online](https://raft.github.io/raft.pdf)
- "How to Create a distributed Datastore in 10 Minutes" Jonathan Halterman [online](https://jodah.net/create-a-distributed-datastore-in-10-minutes)
- "Spark Quickstart" [online](http://spark.apache.org/docs/latest/quick-start.html)
- "Spark Github repository with examples" [online](https://github.com/apache/spark)
- "Spark Tutorial: Real Time Cluster Computing Framework" [online](https://www.edureka.co/blog/spark-tutorial/)
- "Apache Spark Dockerimage" [online](https://github.com/gettyimages/docker-spark)
- "Open-source software for reliable, scalable, distributed computing" [Apache Hadoop](https://hadoop.apache.org/)
- "High-performance coordination service for distributed applications" [Apache Zookeeper](https://zookeeper.apache.org/doc/current/)
- "Distributed data store" [wikipedia](https://en.wikipedia.org/wiki/Distributed_data_store)
- "Understanding Hadoop v/s Spark v/s Storm" [cognixia.com](https://www.cognixia.com/blog/understanding-hadoop-vs-spark-vs-storm)
- "Comparison Storm and Spark" [whizlabs.com](https://www.whizlabs.com/blog/apache-storm-vs-apache-spark/)
- "etcd - A distributed, reliable key-value store" [online](https://etcd.io/)



# Research

## Vergleich

### Atomix [1, 2]

Atomix ist ein Framework um fehlertolerante verteilte Systeme zu entwickeln. Dazu werden Cluster eingesetzt. Dafür gibt es ein Clustermanagement, welches dazu da ist um Fehler zu erkennen und evtl reagieren zu können (Downtimes etc)

Die Kommunikation zwischen den Clustern geschieht mit Netty, wobei direkte Kommunikation oder auch das Pub-Sub Prinzip angewendet werden.

Atomix ermöglicht auch die Verwendung von verteilten Datenstrukturen wie Maps, Sets, Trees, Counters oder Werten. Die Koordination kann über verteile Locks, Semaphoren oder Elections zur Bestimmung der Master/Slaves.

Für Atomix gibt es CLI Bindings. Hauptsächlich ist das Framework jedoch für Java ausgelegt. Es gibt jedoch auch nicht aktuell gehaltene Python Bindings.

Für die Replikation stehen mehrere Protokolle als Dependencies zur Verfügung.

* `atomix-raft` - (stark konsistenter partitionierter Konsensalgorithmus)
* `atomix-primary-backup` - (konsistenter partitionierter Master/slave basierter Replikationsalgorithmus)
* `atomix-gossip` - (hochskalierbares eventuell konsistentes Protokoll)

Diese unterscheiden sich je nach Anforderungen an Fehlertoleranz-, Konsistenz- oder Persistenz-Anforderungen

### Akka



# Quellen

[1] "Atomix - What is Atomix?", zugegriffen am 27.2.2020 [online](https://atomix.io/docs/latest/user-manual/introduction/what-is-atomix/)

[2] "Atomix - Getting Started", zugegriffen am 27.2.2020 [online](https://atomix.io/docs/latest/getting-started/)

