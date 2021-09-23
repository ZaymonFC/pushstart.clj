# 👟 pushstart.clj

Sometimes all you need to do is get a little experiment running in a REPL with a http client, csv-reader, and other utilities.

`pushstart` generates a small project starter containing:

- `deps.edn`
- `script.clj`—Utilities already imported
- `README.md`
- `.gitignore` —tailored to Clojure.

## Utilities

`pushstart.clj` comes with most of the utilities you'll need for small tasks.

- `clojure.set`
- `clojure.string`
- [`clojure.data.json`](https://github.com/clojure/data.json)
- [`clojure.data.csv`](https://github.com/clojure/data.csv)
- [`math.combinatorics`](https://github.com/clojure/math.combinatorics)
- [`camel-snake-kebab`](https://github.com/clj-commons/camel-snake-kebab)
- [`clojure.java-time`](https://github.com/dm3/clojure.java-time)
- [`clj-http`](https://github.com/dakrone/clj-http)
- [`Malli`](https://github.com/metosin/malli)
- [`Hashp`](https://github.com/weavejester/hashp)

## Usage

To use this script with [babashka](https://github.com/babashka/babashka), simply put `pushstart.clj` somewhere on your path. Then:

```sh
mkdir my-project
cd my-project

pushstart.clj # Files will be created in current directory.
```
