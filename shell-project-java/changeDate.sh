#!/bin/bash
if [ -z "$1" ] ; then
  echo 'ERROR: Parameter missing. specify the folder!'
  exit
fi
#MODE=tail # change to newest file
MODE=head # change to oldest file
for d in "$1"/*/; do
  echo "running on $d"
  
    touch "$(find "$d" -mindepth 1 -maxdepth 1 -printf '%T+=%p\n' \
                              | sort | "$MODE" -n 1 | cut -d= -f2-)" "$d" \;

    # remove echo to really run it
done
