# pushstart.clj

Sometimes all you need to do is get a little experiment running in a REPL with a http client, csv-reader, and other utilities.

`pushstart` generates a small project starter containing:

- `deps.edn`
- `script.clj`—Utilities already imported
- `README.md`
- `.gitignore` —tailored to Clojure.

## Usage. This script can be run with `clj` or `bb`

To use this script with [babashka](https://github.com/babashka/babashka), simply put `pushstart.clj` somewhere on your path. Then:

```sh
mkdir my-project
cd my-project

pushstart.clj # Files will be created in current directory.
```
