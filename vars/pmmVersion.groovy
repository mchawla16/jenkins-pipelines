def call(String type='latest') {
  // List<String> oldVersions = ['2.9.1', '2.10.0', '2.10.1', '2.11.0', '2.11.1', '2.12.0', '2.13.0', '2.14.0']
  List<String> oldVersions = ['2.11.0', '2.12.0', '2.13.0']
  HashMap<String, String> versions = [
    // Historical AMIs
    // '2.15.0': 'ami-086a3a95eefa9567f',
    // '2.15.1': 'ami-073928dbea8c7ebc3',
    // '2.16.0': 'ami-01097b383f63f7db5',
    // '2.17.0': 'ami-03af848f3557ff8d0',
    // '2.18.0': 'ami-0184c7b18b45d2a7b',
    // '2.19.0': 'ami-0d3c21da426d248d3',
    // '2.20.0': 'ami-04ad85dd7364bba21',
    // '2.21.0': 'ami-0605d9dbdc9d6a233',
    // '2.22.0': 'ami-0fb9ae57bc30787cd',
    // '2.23.0': 'ami-012c6702ff13e97d0',
    // '2.24.0': 'ami-0e688a9b5dca3b3d2',
    // '2.25.0': 'ami-09931a649be4b90e8',
    // '2.26.0': 'ami-0579b750aaa578090',
    // '2.27.0': 'ami-064970de413ee5144',
    // '2.28.0': 'ami-015cbf0312dd101c7',
    // '2.29.0': 'ami-0e68224439dd6f200',
    // '2.29.1': 'ami-01ce74cdab54cabcd',
    // '2.30.0': 'ami-0ac4cb922edec19e0',
    // '2.31.0': 'ami-04c7431377165bca7',
    // '2.32.0': 'ami-02cfe7580e77fb5fa',
    // '2.33.0': 'ami-005acacf35adcfa57',
    // Newer AMIs, us-east-1
    '2.12.0': 'ami-0b5539a85b450ad6a',
    '2.13.0': 'ami-082bcd79afc35d576',
    '2.19.0': 'ami-0a8d9caa10fb1aaf3',
    '2.20.0': 'ami-0aa5c278075c61158',
    '2.21.0': 'ami-03a64919e4f2afe32',
    '2.22.0': 'ami-0fd1d4c619b968b18',
    '2.23.0': 'ami-0a98f83f5406c379e',
    '2.24.0': 'ami-07008195e6afe0694',
    '2.25.0': 'ami-0b5a9dff554ea6d12',
    '2.26.0': 'ami-09914490ee52c24c6',
    '2.27.0': 'ami-0e1dd6bf6627aed8e',
    '2.28.0': 'ami-0b6ea9aa3292b41dd',
    '2.29.0': 'ami-059b09b175765a958',
    '2.29.1': 'ami-07f8ad99be4ed007b',
    '2.30.0': 'ami-0e7021d395f91de57',
    '2.32.0': 'ami-0bd413810ebb52d5d',
    '2.31.0': 'ami-08094ef29ebc82468',
    '2.33.0': 'ami-07e19e90c30c6989c',
    '2.34.0': 'ami-06dd2cfc9b70bb79b',
  ]

  List<String> versionsList = new ArrayList<>(versions.keySet());
  // Grab 10 latest versions
  List<String> ovfVersions = ['2.34.0', '2.33.0', '2.32.0', '2.31.0', '2.30.0', '2.29.1', '2.28.0', '2.27.0', '2.26.0', '2.25.0', '2.24.0'];

  switch(type) {
    case 'latest':
      def latestVersion = httpRequest "https://raw.githubusercontent.com/Percona-Lab/pmm-submodules/PMM-2.0/VERSION"
      return latestVersion.content
    case 'stable':
      return versionsList[versionsList.size() - 2]
    case 'ami':
      return versions
    case 'list':
      return versionsList
    case 'ovf':
      return ovfVersions
    case 'list_with_old':
      return oldVersions + versionsList
  }
}
